package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class num2302 {
    static int N, M;
    static int[] dp;
    static HashSet<Integer> vips = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        if(N > 1) {
            dp[2] = 2;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        M = stoi(br.readLine());

        for (int i = 0; i < M; i++) {
            vips.add(stoi(br.readLine()));
        }

        int tmp = 0;
        int res = 1;
        for (int i = 1; i <= N; i++) {
            tmp++;

            if(M == 0) continue;

            if(vips.contains(i)) {
                tmp--;
                res *= dp[tmp];
                tmp = 0;
                continue;
            }
        }

        if(tmp!=0) res *= dp[tmp];

        System.out.println(res);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
