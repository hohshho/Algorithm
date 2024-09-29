package 유형별문제.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2502
public class num2502 {
    static int D, K;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dp = new int[D];

        // dp를 채워야 되는데 2개 다 모르니 전부 완탐
        // dp[i] = dp[i - 1] + dp[i - 2]
        for(int i=1; i<=K/2; i++){
            for(int j=i+1; j<K; j++){
                dp[0] = i;
                dp[1] = j;

                for(int k=2; k<D; k++){
                    dp[k] = dp[k-1] + dp[k-2];
                }

                if(dp[D-1] == K) break;
            }
            if(dp[D-1] == K) break;
        }

        System.out.println(dp[0]);
        System.out.println(dp[1]);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
