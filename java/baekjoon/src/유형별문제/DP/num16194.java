package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dp는 민규가 구매할 수 있는 금액의 최소값
        int N = stoi(br.readLine());
        int[] dp = new int[N + 1];

        String[] data = br.readLine().split(" ");

        for(int i = 1; i <= N; i++){
            dp[i] = stoi(data[i-1]);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }


        System.out.println(dp[N]);

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
