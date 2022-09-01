package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] inputData = br.readLine().split(" ");
		int[] arr = new int[N+1];
		int max;
		int[] dp = new int[N+1];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(inputData[i]);
		}
		
		max = arr[0];
		dp[0] = arr[0];
		for(int i=1;i<N;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
			max = Math.max(max,dp[i]);
		}
		for(int i=0;i<N;i++) {
			System.out.println(dp[i]);
		}
		System.out.println(max);
		
	}

}
