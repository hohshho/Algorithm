package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11726 {
	static int n;
	static int[] dp;
	static int mod = 10007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		if(n>=2) {
			dp[1]=1;
			dp[2]=2;
			if(n>=3) {
				calc(3);
			}
			System.out.println(dp[n]);
		}
		else System.out.println(1);
		
	}
	
	public static void calc(int depth) {
		if(depth > n)
			return;
		dp[depth] = (dp[depth-1] + dp[depth-2])%mod;
		calc(depth+1);
	}
}
