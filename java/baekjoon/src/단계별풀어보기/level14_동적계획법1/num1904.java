package 단계별풀어보기.level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1904 {
	static int[] dp;
	static int n;
	static int count= 0;
	
	static int calcCount(int n) {
		if(dp[n]==-1) {
			dp[n]= (calcCount(n-1) + calcCount(n-2))%15746;
		}
		return dp[n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		for(int i=0;i<n+1;i++) {
			dp[i] = -1;
		}
		
		dp[1]=1;
		if(n>2) {
			dp[2]=2;
			calcCount(n);
			System.out.println(dp[n]);
		}
		else if(n==1)
			System.out.println(1);
		else if(n==2)
			System.out.println(2);
		
	}

}
