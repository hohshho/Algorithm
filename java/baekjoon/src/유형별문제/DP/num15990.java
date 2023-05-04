package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15990 {
    static int N, max = 0;
    static int[] T;
    static long[][] dp;
    static int[] res;
    static int[][] next = new int[][]{{2, 3}, {1, 3}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        T = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            T[i] = stoi(br.readLine());
            max = Math.max(max, T[i]);
        }

        dp = new long[4][max + 1];
        // 초기값
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;


        for (int i = 4; i <= max; i++) {
                dp[1][i] = (dp[2][i - 1] + dp[3][i - 1]) % 1000000009;
                dp[2][i] = (dp[1][i - 2] + dp[3][i - 2]) % 1000000009;
                dp[3][i] = (dp[1][i - 3] + dp[2][i - 3]) % 1000000009;
        }

        for (int t = 1; t <= N; t++) {
            long res = (dp[1][T[t]] + dp[2][T[t]] + dp[3][T[t]]) % 1000000009;
            System.out.println(res);
        }
    }

    public static Integer stoi(String s) {
        return Integer.parseInt(s);
    }
}
