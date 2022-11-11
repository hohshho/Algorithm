package level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11054 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] inputData = br.readLine().split(" ");
		int[][] dp = new int[N][2];
		int max = 0;
		int index;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(inputData[i]);
		}
		dp[0][0] = 1;
		dp[N-1][1] = 1;
		for(int i=1; i<N; i++) {
			dp[i][0] = 1;
			for(int j=0; j<=i; j++) {
				if(arr[i] > arr[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				}
			}
		}
		for(int i=N-2; i>=0; i--) {
			dp[i][1] = 1;
			for(int j=N-1; j>=i; j--) {
				if(arr[i] > arr[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
				}
			}
		}
		for(int i=0; i<N; i++) {
			index = dp[i][0] + dp[i][1] -1 ;
			max = index > max ? index : max;
		}
		System.out.println(max);
		
	}
}
