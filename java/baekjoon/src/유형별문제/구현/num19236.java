package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class num19236 {
    static int N = 4, res = 0;
    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1}, dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // y, x
        int[][] IndexMap = new int[4][4];
        Fish[] List = new Fish[17];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int mapIdx = 0;
            for (int j = 0; j < N; j++) {
                int fishNum = stoi(input[mapIdx]);
                int fishDirection = stoi(input[mapIdx + 1]) - 1;

                IndexMap[i][j] = fishNum;
                List[fishNum] = new Fish(j, i, fishNum, fishDirection);
                mapIdx += 2;
            }
        }

        dfs(IndexMap, List, IndexMap[0][0], 0);

        System.out.println(res);
    }

    public static void dfs(int[][] fishIndexMap, Fish[] fishList, int eatFishIndex, int sum) {
        Fish[] temp_fishList = new Fish[17];
        int[][] temp_fishIndexMap = new int[4][4];

        for (int i = 1; i < 17; i++) {
            if(fishList[i] == null) continue;

            temp_fishList[i] = new Fish(fishList[i].x, fishList[i].y, fishList[i].n, fishList[i].direction);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp_fishIndexMap[i][j] = fishIndexMap[i][j];
            }
        }

        // 1. 상어 먹음
        Fish eat = fishList[eatFishIndex];
        sum += eat.n;
        res = Math.max(res, sum);
        temp_fishList[eat.n] = null;
        temp_fishIndexMap[eat.y][eat.x] = -1;

        // 2. 작은 물고기 부터 (저장 할 linkedList) / 다른 물고기 o(교체), 빈칸
        Fish shark = new Fish(eat.x, eat.y, 17, eat.direction);

        // 물고기 이동
        for (int i = 1; i < 17; i++) {
            // 먹힌 경우 pass
            // 잘못 푼 부분 이유 : map은 계속 바뀌는데 먹은 fish의 map 위치로 확인했었음
            if (temp_fishList[i] == null) continue;

            Fish cur = temp_fishList[i];

            int nextDirection = cur.direction;

            for (int j = 0; j < 8; j++) {
                if (j != 0) {
                    nextDirection++;
                    if (nextDirection > 7) nextDirection = 0;
                }

                int nx = cur.x + dx[nextDirection];
                int ny = cur.y + dy[nextDirection];

                // 없는 공간, 상어 위치인 경우 pass
                if (!checkPosition(nx, ny)) continue;
                if (shark.x == nx && shark.y == ny) continue;

                // 빈 칸인 경우
                if (temp_fishIndexMap[ny][nx] == -1) {
                    // 이동
                    temp_fishIndexMap[cur.y][cur.x] = -1;
                    temp_fishIndexMap[ny][nx] = cur.n;

                    temp_fishList[i] = new Fish(nx, ny, i, nextDirection);
                    break;
                }

                // 다른 물고기 인 경우(교체)
                int target = temp_fishIndexMap[ny][nx];
                temp_fishIndexMap[ny][nx] = i;
                temp_fishIndexMap[cur.y][cur.x] = target;

                temp_fishList[target] = new Fish(cur.x, cur.y, temp_fishList[target].n, temp_fishList[target].direction);
                temp_fishList[i] = new Fish(nx, ny, i, nextDirection);
                break;
            }
        }

        for (int i = 1; i < 4; i++) {
            int nx = shark.x + dx[shark.direction] * i;
            int ny = shark.y + dy[shark.direction] * i;

            if (!checkPosition(nx, ny)) break;
            if (temp_fishIndexMap[ny][nx] != -1) {
                dfs(temp_fishIndexMap, temp_fishList, temp_fishIndexMap[ny][nx], sum);
            }
        }
    }

    static boolean checkPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Fish {
        int x, y, direction, n; // n = 17 상어

        Fish(int x, int y, int n, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.n = n;
        }
    }
}
