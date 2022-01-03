package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for(int i = 0; i< T; i++){
			int N = stoi(br.readLine());

			System.out.println(calc(N));
		}
	}

	public static int calc(int n){
		int res;
		int[] dp = new int[n];

		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;

		if(n <= 3){
			res = dp[dp.length];
		}else{
			res = calc(n-1) + calc(n-2) + calc(n-3);
		}
		return res;
	}

	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
