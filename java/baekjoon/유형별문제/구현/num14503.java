package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class num14503 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        String[] XYD = br.readLine().split(" ");

        int N = stoi(NM[0]); // 세로 y
        int M = stoi(NM[1]); // 가로 x
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(line[j]);
            }
        }

        Robot robot = new Robot(N, M, stoi(XYD[0]), stoi(XYD[1]), stoi(XYD[2]));

        robot.run();

        System.out.println(robot.getCleanAreaCnt());
    }

    static class Robot {
        enum Direction {
            NORTH(0),
            EAST(1),
            SOUTH(2),
            WEST(3);

            private final int code;

            private static final Map<Integer, Direction> codeMap = new HashMap<>();
            // north, east, south, west 순
            private static final int[] dx = new int[]{0, 1, 0, -1};
            private static final int[] dy = new int[]{-1, 0, 1, 0};

            static {
                for (Direction direction : values()) {
                    codeMap.put(direction.code, direction);
                }
            }

            Direction(int code) {
                this.code = code;
            }

            static Direction getType(final int code) {
                return codeMap.get(code);
            }

            // 반시계 방향 회전
            Direction rotate() {
                if (this == NORTH) {
                    return WEST;
                }
                return this.getType(this.code - 1);
            }

            int getNextX(int x) {
                return x + dx[this.code];
            }

            int getNextY(int y) {
                return y + dy[this.code];
            }

            int getBackX(int x) {
                return x + dx[(this.code + 2) % 4];
            }

            int getBackY(int y) {
                return y + dy[(this.code + 2) % 4];
            }
        }

        class State {
            int x, y, nx, ny, bx, by;
            Direction direction;

            State(int x, int y, Direction direction) {
                this.x = x;
                this.y = y;
                this.nx = direction.getNextX(x);
                this.ny = direction.getNextY(y);
                this.bx = direction.getBackX(x);
                this.by = direction.getBackY(y);
                this.direction = direction;
            }

            void changeRocate() {
                this.direction = direction.rotate();
                this.nx = direction.getNextX(x);
                this.ny = direction.getNextY(y);
                this.bx = direction.getBackX(x);
                this.by = direction.getBackY(y);
            }

            boolean checkNextArea() {
                // map 범위 검사, 벽 검사, 청소 여부
                return nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] != 1 && map[ny][nx] != -1;
            }

            boolean checkBackArea() {
                // map 범위 검사, 벽 검사, 청소 여부
                return bx >= 0 && by >= 0 && bx < M && by < N && map[by][bx] != 1;
            }

            State go() {
                return new State(nx, ny, this.direction);
            }

            State back() {
                return new State(bx, by, this.direction);
            }
        }

        // action에 대한 Queue
        Queue<State> taskQueue = new LinkedList<>();
        // 청소 된 칸 수
        int cleanAreaCnt;
        // N, M
        int N, M;

        Robot(int N, int M, int y, int x, int direction) {
            this.N = N;
            this.M = M;

            taskQueue.add(new State(x, y, Direction.getType(direction)));
            cleanAreaCnt = 0;
        }

        void run() {
            while (!taskQueue.isEmpty()) {
                State cur = taskQueue.poll();

                // 1. 현재 위치 청소
                if (map[cur.y][cur.x] == 0) {
                    cleanAreaCnt++;
                }
                map[cur.y][cur.x] = -1;

                // 2. 청소할 방향 탐색, 작업 추가
                int wallCnt = 0;
                while (wallCnt != Direction.values().length) {
                    cur.changeRocate();

                    if (cur.checkNextArea()) {
                        taskQueue.add(cur.go());
                        break;
                    }

                    wallCnt++;
                }

                // 청소할 곳이 있는 경우 q에 적재 후 continue;
                if (wallCnt < 4) {
                    continue;
                }

                // 3. 모두 청소가 된 경우
                //  3.1 뒤가 벽이 아닐 경우 1칸 후진
                if (cur.checkBackArea()) {
                    taskQueue.add(cur.back());
                    continue;
                }

                //  3.2 뒤가 벽일 경우 종료
                return;
            }
        }

        int getCleanAreaCnt() {
            return this.cleanAreaCnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
