package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class num14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        String[] XYD = br.readLine().split(" ");

        int N = stoi(NM[0]); // 세로 y
        int M = stoi(NM[1]); // 가로 x
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(line[j]);
            }
        }

        Robot robot = new Robot(N, M, stoi(XYD[0]), stoi(XYD[1]), stoi(XYD[2]), map);

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

            static int getCode(final Direction direction) {
                return direction.code;
            }

            static Direction rotate(Direction direction) {
                if (direction == NORTH) {
                    return WEST;
                }
                return direction.getType(direction.code - 1);
            }

            static Direction back(Direction direction) {
                return Direction.getType((Direction.getCode(direction) + 2) % 4);
            }

            static int getNextX(Direction direction, int x) {
                return x + dx[Direction.getCode(direction)];
            }

            static int getNextY(Direction direction, int y) {
                return y + dy[Direction.getCode(direction)];
            }
        }

        class State {
            int x, y;
            Direction direction;

            State(int x, int y, Direction direction) {
                this.x = x;
                this.y = y;
                this.direction = direction;
            }

            void changeRocate() {
                this.direction = Direction.rotate(this.direction);
            }
        }

        // action에 대한 Queue
        Queue<State> taskQueue = new LinkedList<>();
        // map 정보
        int[][] map;
        // 청소 된 칸 수
        int cleanAreaCnt;
        // N, M
        int N, M;

        Robot(int N, int M, int y, int x, int direction, int[][] map) {
            this.N = N;
            this.M = M;

            taskQueue.add(new State(x, y, Direction.getType(direction)));
            this.map = map.clone();
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
                State next = null;
                int wallCnt = 0;
                while (wallCnt != Direction.values().length) {
                    cur.changeRocate();

                    int nx = Direction.getNextX(cur.direction, cur.x);
                    int ny = Direction.getNextY(cur.direction, cur.y);

                    if (checkArea(nx, ny, cur.direction, 1)) {
                        next = new State(nx, ny, cur.direction);
                        break;
                    }

                    wallCnt++;
                }

                // 청소할 곳이 있는 경우 q에 적재 후 continue;
                if (wallCnt < 4) {
                    taskQueue.add(next);
                    continue;
                }

                // 3. 모두 청소가 된 경우
                int bx = Direction.getNextX(Direction.back(cur.direction), cur.x);
                int by = Direction.getNextY(Direction.back(cur.direction), cur.y);

                //  3.1 뒤가 벽이 아닐 경우 1칸 후진
                if (checkArea(bx, by, cur.direction, 0)) {
                    if (map[by][bx] != 1) {
                        taskQueue.add(new State(bx, by, cur.direction));
                        continue;
                    }
                }

                //  3.2 뒤가 벽일 경우 종료
                return;
            }
        }

        // flag = 1 : 청소 여부 검사 O , 0 : 청소 여부 검사 X
        boolean checkArea(int x, int y, Direction direction, int flag) {
            boolean check = x >= 0 && y >= 0 && x < M && y < N &&    // map 범위 검사
                    map[y][x] != 1;                                  // 벽 검사

            if (flag == 0) {
                return check;
            }

            return check && map[y][x] != -1;                       // 청소 여부 검사
        }

        int getCleanAreaCnt() {
            return this.cleanAreaCnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
