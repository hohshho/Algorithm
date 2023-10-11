package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class num23289 {
    static int R, C, K, W, INF = Integer.MAX_VALUE, result = INF;
    // [온풍기방향][x변화][y변화]
    // 방향 - 0 : 오른쪽, 1 : 왼쪽, 2 : 위, 3 : 아래
    static int[][][] wind = new int[][][]{
            {{}, {}},
            {{}, {}},
            {{}, {}},
            {{}, {}}
    };
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    // Key : x, Value : y
    static HashMap<Integer, Integer> walls = new HashMap<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();

        int chocolate = 0;
        while (chocolate <= 100) {
            runMachine();
            controlTemperature();
            decreaseSide();

            chocolate += 1;

            if (checkTemperature()) break;
        }

        System.out.println(chocolate);
    }

    public static boolean checkTemperature() {
        return true;
    }

    public static void decreaseSide() {

    }

    public static void controlTemperature() {

    }

    public static void runMachine() {

    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = stoi(st.nextToken());

                // TODO:
            }
        }

        W = stoi(br.readLine());
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int direction = stoi(st.nextToken());

            // TODO: 좌표 확인

        }
    }

    static class Wall {
        boolean top, bottom, left, right;

        Wall() {
        }

        void addDirection(int direction) {
            if (direction == 0) {
                this.right = true;
            } else if (direction == 1) {
                this.left = true;
            } else if (direction == 2) {
                this.top = true;
            } else if (direction == 3) {
                this.bottom = true;
            }
        }
    }

    static class Machine {
        int direction, x, y;

        Machine(int direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
