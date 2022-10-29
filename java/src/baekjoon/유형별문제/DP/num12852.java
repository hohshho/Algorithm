package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num12852 {
    static int N, res;
    static Point[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        dp = new Point[N + 1];
        dp[1] = new Point(0, "1");

        for (int i = 2; i <= N; i++) {
            int n = dp[i - 1].n + 1;
            int preIndex = i - 1;

            if (i % 2 == 0 && n > dp[i / 2].n + 1) {
                n = dp[i / 2].n + 1;
                preIndex = i / 2;
            }

            if (i % 3 == 0 && n > dp[i / 3].n + 1) {
                n = dp[i / 3].n + 1;
                preIndex = i / 3;
            }

            dp[i] = new Point(dp[preIndex].n + 1, i + " " + dp[preIndex].path);
        }

        System.out.println(dp[N].n);
        System.out.println(dp[N].path);

    }

    static class Point {

        int n;
        String path;

        Point(int n, String path) {
            this.n = n;
            this.path = path;
        }
    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
