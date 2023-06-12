package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num19237 {
    static int N, M, k, res;
    // 1 - 위, 2 - 아래, 3 - 왼쪽, 4 - 오른쪽
    static int[] dx = {0, 0, 0, -1, 1}, dy = {0, -1, 1, 0, 0};
    static HashMap<Integer, Shark> sharks = new HashMap<>();
    static Point[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        k = stoi(st.nextToken());

        map = new Point[N][N];

        // input map data
        for (int i = 0; i < N; i++) { // y
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // x
                String input = st.nextToken();

                if (input.equals("0")) continue;

                sharks.put(stoi(input), new Shark(j, i, stoi(input)));
            }

        }

        // input default shark direction
        st = new StringTokenizer(br.readLine());
        for (int sharkIndex : sharks.keySet()) {
            Shark shark = sharks.get(sharkIndex);
            shark.setDirection(stoi(st.nextToken()));
        }

        // input shark priority direction
        for (int sharkIndex : sharks.keySet()) {
            Shark shark = sharks.get(sharkIndex);

            for (int i = 0; i < 4; i++) {
                String[] inputs = br.readLine().split(" ");

                shark.setPriority(inputs);
            }
        }

        saveSmell();

        while (res < 1001) {
            // 2. 상어 이동 냄새가 없는 칸으로 -> 기존에 존재하는 상어 있으면 상어 이동하지 않고 상어 삭제 -> (전부 있으면 자신의 냄새가 있는 곳.)
            moveShark();

            // 3. 맵에 유지중인 냄세 count 업데이트
            updateSmell();

            saveSmell();

            res += 1;

            if (sharks.size() == 1) {
                break;
            }
        }

        System.out.println(res < 1001 ? res : -1);
    }

    public static void saveSmell() {
        for (int sharkIndex : sharks.keySet()) {
            Shark shark = sharks.get(sharkIndex);

            map[shark.y][shark.x] = new Point(shark.x, shark.y, shark.index, k);
        }
    }

    public static void moveShark() {
        HashSet<Integer> removeIndex = new HashSet<>();

        for (int sharkIndex : sharks.keySet()) {
            Shark shark = sharks.get(sharkIndex);
            int[] priorityDirection = shark.getPriority();

            // 1. 우선순위에 따른 방향 탐색
            int nextDirection = 0;
            // 아무 냄새가 없는 칸
            for (int direction : priorityDirection) {
                int nx = shark.x + dx[direction];
                int ny = shark.y + dy[direction];

                if(!checkValue(nx, ny)) continue;

                if(map[ny][nx] != null) continue;

                nextDirection = direction;
                break;
            }

            // 2. 우선 순위에 없을 경우 이전 위치 방향 설정
            if (nextDirection == 0) {
                for (int direction : priorityDirection) {
                    int nx = shark.x + dx[direction];
                    int ny = shark.y + dy[direction];

                    if(!checkValue(nx, ny)) continue;

                    if(map[ny][nx] == null) continue;

                    Point point = map[ny][nx];

                    if(point.sharkNum == shark.index) {
                        nextDirection = direction;
                        break;
                    }
                }
            }

            // 3. 방향으로 상어 이동 (객체라 얕은 복사 / 현재 객체 값 변경)
            shark.setDirection(nextDirection);
            shark.x = shark.x + dx[nextDirection];
            shark.y = shark.y + dy[nextDirection];
        }

        // 같은 위치에 있는 상어 삭제
        int[][] visited = new int[N][N];
        LinkedList<Integer> si = new LinkedList<>();

        for (int sharkIndex : sharks.keySet()) {
            Shark cur = sharks.get(sharkIndex);

            if (visited[cur.y][cur.x] == 0) {
                visited[cur.y][cur.x] = cur.index;
                continue;
            }

            if (visited[cur.y][cur.x] < cur.index) {
                si.push(cur.index);
            } else {
                si.push(visited[cur.y][cur.x]);
                visited[cur.y][cur.x] = cur.index;
            }
        }

        for (int index : si) {
            sharks.remove(index);
        }
    }

    public static void updateSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == null) continue;

                map[i][j].count -= 1;

                if(map[i][j].count == 0) map[i][j] = null;
            }
        }
    }

    public static boolean checkValue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static class Point {
        int x, y, sharkNum, count;

        Point(int x, int y, int sharkNum, int count) {
            this.x = x;
            this.y = y;
            this.sharkNum = sharkNum;
            this.count = count;
        }
    }

    public static class Shark {
        int x, y, index, direction;
        int[] upPriority, downPriority, leftPriority, rightPriority;

        Shark(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        void setDirection(int direction) {
            this.direction = direction;
        }

        int[] getPriority() {
            if (this.direction == 1) {
                return this.upPriority;
            } else if (this.direction == 2) {
                return this.downPriority;
            } else if (this.direction == 3) {
                return this.leftPriority;
            } else {
                return this.rightPriority;
            }
        }

        void setPriority(String[] data) {
            int[] list = new int[4];
            for (int i = 0; i < data.length; i++) {
                list[i] = stoi(data[i]);
            }

            if (upPriority == null) {
                upPriority = list.clone();
            } else if (downPriority == null) {
                downPriority = list.clone();
            } else if (leftPriority == null) {
                leftPriority = list.clone();
            } else if (rightPriority == null) {
                rightPriority = list.clone();
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
