package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9657 {
    static int N;
    static boolean[] dp = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i <= N; ++i) {
            dp[i] = false;
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4])
                dp[i] = true;
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
