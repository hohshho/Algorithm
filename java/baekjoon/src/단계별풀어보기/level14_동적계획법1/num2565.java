package 단계별풀어보기.level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class num2565 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[][] arr = new int[N][2];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(inputData[0]);
			arr[i][1] = Integer.parseInt(inputData[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i][0]);
		}
		
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(N-max);
	}
}
