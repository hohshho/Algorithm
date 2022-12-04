package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15988 {
    static int N, max = 0;
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = stoi(br.readLine());
            max = Math.max(max, T[i]);
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int dpLen = 3;
        for (int value : T) {
            if (dpLen >= value) {
                System.out.println(dp[value]);
                continue;
            }

            for (int i = dpLen + 1; i <= value; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
                dpLen++;
            }

            System.out.println(dp[value]);
        }

    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
