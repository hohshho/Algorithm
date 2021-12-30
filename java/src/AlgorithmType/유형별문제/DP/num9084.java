package package22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		
		for(int i=0; i<N; i++) {
			int coinCount = stoi(br.readLine());
			int[] coinArr = new int[coinCount];
			String[] coinData = br.readLine().split(" ");
			int M = stoi(br.readLine());
			
			for(int j=0; j<coinCount; j++) {
				coinArr[j] = stoi(coinData[j]);
			}

			int[] dp = new int[M+1];
			dp[0] = 1;
			for(int j=0; j<coinCount; j++) {
				for(int k=coinArr[j]; k<=M; k++) {
					dp[k] += dp[k - coinArr[j]];
				}
			}
			sb.append(dp[M] + "\n");
		}
		System.out.println(sb);
		
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
