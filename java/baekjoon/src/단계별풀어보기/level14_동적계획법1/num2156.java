package 단계별풀어보기.level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 경우의 수는 3가지 이다.
 * 
 * oox / xoo / oxo
 */

public class num2156 {
	static int[] arr;
	static int[] dp;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
        if (N >= 1) {
            dp[1] = arr[1];
        }
        // 두잔일 경우
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        // 세잔일 경우
        if (N >= 3) {
            dp[3] = Math.max(dp[2], Math.max(dp[1] + arr[3], arr[2] + arr[3]));
        }
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}
		
		System.out.println(dp[N]);
	}

}
