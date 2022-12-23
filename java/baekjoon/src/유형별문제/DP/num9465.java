package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9465 {
    static int T, N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = stoi(br.readLine());

            int[][] map = new int[2][n];
            int[][] dp = new int[3][n + 1];

            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                map[0][j] = stoi(line1[j]);
                map[1][j] = stoi(line2[j]);
            }

            for (int j = 0; j < n; j++) {
                dp[0][j + 1] = Math.max(dp[0][j + 1], Math.max(dp[0][j], Math.max(dp[1][j], dp[2][j])));
                dp[1][j + 1] = Math.max(dp[1][j + 1], Math.max(dp[0][j], dp[2][j]) + map[0][j]);
                dp[2][j + 1] = Math.max(dp[2][j + 1], Math.max(dp[0][j], dp[1][j]) + map[1][j]);
            }

            System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
