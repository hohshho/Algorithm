package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1520 {
    static int M, N, res = 0;
    static int[][] map, dp;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(search(0, 0));
    }

    public static int search(int x, int y) {
        if(y == N - 1 && x == M - 1) {
            return 1;
        }

        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!checkMap(nx, ny)) continue;

            if(map[y][x] <= map[ny][nx]) continue;

            dp[y][x] += search(nx, ny);
        }

        return dp[y][x];
    }

    public static boolean checkMap(int x, int y){
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
