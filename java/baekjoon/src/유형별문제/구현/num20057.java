package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class num20057 {
    static int[][] map;
    static int N, res = 0, move = 0;
    static Point point;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static LinkedList<Move>[] moves = new LinkedList[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
            }
        }

        // 중앙값으로 시작
        point = new Point(N / 2, N / 2);
        insertMoveData();
        run();

        System.out.println(res);
    }

    public static void run() {
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) move += 1;

                for (int j = 0; j < move; j++) {
                    // 종료 조건
                    if (point.x == 0 && point.y == 0) return;

                    point.x = point.x + dx[i];
                    point.y = point.y + dy[i];

                    moveSand(point.x, point.y, i);
                }
            }
        }
    }

    public static void insertMoveData() {
        for (int i = 0; i < 4; i++) {
            LinkedList<Move> list = new LinkedList<>();

            if (i % 2 == 0) {
                list.add(new Move(1, -dx[i], 1));
                list.add(new Move(1, -dx[i], -1));
                list.add(new Move(7, 0, 1));
                list.add(new Move(7, 0, -1));
                list.add(new Move(2, 0, 2));
                list.add(new Move(2, 0, -2));
                list.add(new Move(10, dx[i], 1));
                list.add(new Move(10, dx[i], -1));
                list.add(new Move(5, 2 * dx[i], 0));
                list.add(new Move(100, dx[i], 0));
            } else {
                list.add(new Move(1, 1, -dy[i]));
                list.add(new Move(1, -1, -dy[i]));
                list.add(new Move(7, 1, 0));
                list.add(new Move(7, -1, 0));
                list.add(new Move(2, 2, 0));
                list.add(new Move(2, -2, 0));
                list.add(new Move(10, 1, dy[i]));
                list.add(new Move(10, -1, dy[i]));
                list.add(new Move(5, 0, 2 * dy[i]));
                list.add(new Move(100, 0, dy[i]));
            }
            moves[i] = list;
        }

    }

    public static void moveSand(int x, int y, int direction) {
        int sandAmount = map[y][x];
        int removeWeight = 0;
        map[y][x] = 0;

        for (Move move : moves[direction]) {
            int moveWeight = (sandAmount * move.rate) / 100;
            if (moveWeight <= 0) continue;

            if (move.rate == 100) {
                if (checkPoint(x + move.nx, y + move.ny)) {
                    map[y + move.ny][x + move.nx] += sandAmount - removeWeight;
                }else {
                    res += sandAmount - removeWeight;
                }
                return;
            }

            if (checkPoint(x + move.nx, y + move.ny)) {
                map[y + move.ny][x + move.nx] += moveWeight;
            } else {
                res += moveWeight;
            }
            removeWeight += moveWeight;
        }
    }

    public static boolean checkPoint(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Move {
        int rate, nx, ny;

        Move(int rate, int nx, int ny) {
            this.rate = rate;
            this.nx = nx;
            this.ny = ny;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
