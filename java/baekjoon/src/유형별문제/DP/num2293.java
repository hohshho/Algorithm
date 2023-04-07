package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int[] coins = new int[N + 1];
        int[] dp = new int[K + 1];
        dp[0] = 1;

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            coins[i] = stoi(st.nextToken());
            for (int j = coins[i]; j < K; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
