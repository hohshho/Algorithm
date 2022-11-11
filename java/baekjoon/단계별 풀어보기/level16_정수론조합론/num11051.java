package level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11051 {
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		int N = Integer.parseInt(inputData[0]);
		int K = Integer.parseInt(inputData[1]);
		dp = new int[N+1][K+1];
		
		System.out.println(combination(N, K));
		
	}
	public static int combination(int n, int r) {
		if(dp[n][r] > 0)
			return dp[n][r];
		if(n == r || r == 0) 
			return dp[n][r] = 1;
		else 
			return dp[n][r] = (combination(n - 1, r - 1) + combination(n - 1, r))%10007; 
	}
}
