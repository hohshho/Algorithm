package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num20058 {
    static int N, Q, mapSize, sum, res;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1}, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        Q = stoi(st.nextToken());

        mapSize = (int) Math.round(Math.pow(2, N));
        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        L = new int[Q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            // 회전
//            map = divide(L[i]);

            // 얼음 처리
//            map = iceProcess();
        }

        getRes();

        System.out.println(sum);
        System.out.println(res);
    }

//    public static int[][] divide(int depth) {
//
//    }

    public static void rotate(int y, int x, int depth, int[][] tmp) {

    }

//    public static int[][] iceProcess() {
//
//    }

    public static void getRes() {

    }

    public static class Point {
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
