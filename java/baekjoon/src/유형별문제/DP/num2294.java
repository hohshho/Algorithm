package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2294 {
    static int N, K, coins[], dp[], INF = Integer.MAX_VALUE - 1, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");

        N = stoi(NK[0]);
        K = stoi(NK[1]);

        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = stoi(br.readLine());
        }

        dp = new int[K + 1];

        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        System.out.println(dp[K] == INF? -1 : dp[K]);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
