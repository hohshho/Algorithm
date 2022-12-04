package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2294 {
    static int N, K, coins[], dp[][], min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");

        N = stoi(NK[0]);
        K = stoi(NK[1]);

        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = stoi(br.readLine());
            min = Math.min(min, coins[i]);
        }

        min = K / min + 1;
        dp = new int[N][min];

        for (int i = 0; i < min; i++) {
            
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
