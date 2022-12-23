package 단계별풀어보기.level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1010 {
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) {
			String[] data = br.readLine().split(" ");
			int n = Integer.parseInt(data[0]);
			int k = Integer.parseInt(data[1]);
			dp = new int[k+1][n+1];
			sb.append(combination(k,n)+"\n");
		}
		System.out.println(sb);
		
	}
	public static int combination(int n, int k) {
		if(dp[n][k] > 0 ) {
			return dp[n][k];
		}
		if(n == k || k == 0)
			return dp[n][k] = 1;
		else
			return dp[n][k] = combination(n-1,k-1) + combination(n-1,k);
	}
}
