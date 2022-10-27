package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11053 {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputData = br.readLine().split(" ");
		arr = new int[n];
		int[] dp = new int[n+1];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(inputData[i]);
		}
		
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++)
			      if(arr[j] < arr[i])
			    	  dp[i] = Math.max(dp[i], dp[j]+1);
		}
		
		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}
		
		System.out.println(max);
	}
}
