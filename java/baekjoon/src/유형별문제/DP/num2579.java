package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15650
public class num2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] list = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i=1; i<=N; i++){
            list[i] = stoi(br.readLine());
        }

        if(N==1) {
            System.out.println(list[1]);
            return;
        }
        if(N==2) {
            System.out.println(list[1]+list[2]);
            return;
        }

        dp[1] = list[1];
        dp[2] = list[1] + list[2];
        dp[3] = Math.max(list[1]+list[3],list[2]+list[3]);
        for(int i=4; i<=N; i++){
            dp[i] = Math.max(dp[i-3] + list[i-1], dp[i-2]) + list[i];
        }

        System.out.println(dp[N]);

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
