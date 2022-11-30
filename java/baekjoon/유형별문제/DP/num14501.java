package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());

        int dp[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String[] TP = br.readLine().split(" ");

            int T = stoi(TP[0]);
            int P = stoi(TP[1]);

            if (i + T <= n && dp[i + T] < dp[i] + P) {
                dp[i + T] = dp[i] + P;
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
