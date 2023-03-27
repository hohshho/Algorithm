package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num15685 {
    static int N, res;
    // 동 / 북 / 서 / 남
    static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
    static boolean[][] maps = new boolean[101][101];
    static LinkedList<DragonCurve> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new DragonCurve(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
        }

        for (DragonCurve dragonCurve : list) {
            run(dragonCurve);
        }

        calcResult();

        System.out.println(res);
    }

    static void calcResult() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (maps[i][j] && maps[i][j + 1] && maps[i + 1][j] && maps[i + 1][j + 1]) {
                    res++;
                }
            }
        }
    }

    static void run(DragonCurve dragonCurve) {
        Point cur = new Point(dragonCurve.x, dragonCurve.y);
        maps[cur.y][cur.x] = true;
        cur.x += dx[dragonCurve.direction];
        cur.y += dy[dragonCurve.direction];
        maps[cur.y][cur.x] = true;

        for (int i = 0; i < dragonCurve.depth; i++) {
            LinkedList<Integer> directions = (LinkedList<Integer>) dragonCurve.directions.clone();
            for (int direction : directions) {
                // 시계 방향 추가
                direction = direction == 3 ? 0 : direction + 1;
                dragonCurve.directions.addFirst(direction);

                // 현재 위치 이동
                cur.x += dx[direction];
                cur.y += dy[direction];
                maps[cur.y][cur.x] = true;
            }
        }

    }

    static boolean checkMapArrange(int x, int y) {
        return x >= 0 && y >= 0 && x < 100 && y < 100;
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class DragonCurve {
        // 초기 입력 값
        int x, y, direction, depth;
        LinkedList<Integer> directions;

        DragonCurve(int x, int y, int direction, int depth) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.depth = depth;
            this.directions = new LinkedList<>();
            this.directions.add(direction);
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
