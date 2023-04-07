package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = stoi(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = stoi(br.readLine());
            dp[i] = 1;
        }

        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(list[i] <= list[j]) continue;

                dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(N - max);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
