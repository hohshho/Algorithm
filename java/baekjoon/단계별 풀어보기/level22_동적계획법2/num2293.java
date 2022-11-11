package level22_동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputNK = br.readLine().split(" ");
		int N = stoi(inputNK[0]);
		int K = stoi(inputNK[1]);
		int[] coins = new int[K+1];
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for(int i=0; i<N; i++) {
			coins[i] = stoi(br.readLine());
			for(int j=coins[i]; j<=K; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(dp[K]);
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
