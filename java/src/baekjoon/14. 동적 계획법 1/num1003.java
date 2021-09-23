package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max)
				max=arr[i];
		}
		int[][] output = new int[max+1][2];
		
		output[0][0] = 1;
		output[0][1] = 0;
		output[1][0] = 0;
		output[1][1] = 1;
		
		for(int i=2;i<=max;i++) {
			output[i][0] = output[i-1][0] + output[i-2][0];
			output[i][1] = output[i-1][1] + output[i-2][1];
		}

		for(int i=0;i<n;i++) {
			sb.append(output[arr[i]][0] + " " + output[arr[i]][1] + "\n");
		}
		
		System.out.println(sb);
	}

}
