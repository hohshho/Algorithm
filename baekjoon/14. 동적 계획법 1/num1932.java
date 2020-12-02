package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1932 {
	static int[][] arr;
	
	static void calcMax() {
		for(int i=arr.length-2;i>=0;i--) {
			for(int j=i;j>=0;j--) {
				arr[i][j] = arr[i+1][j] > arr[i+1][j+1] ? arr[i][j] + arr[i+1][j] : arr[i][j] + arr[i+1][j+1]; 
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0;j<inputData.length;j++) {
				arr[i][j] = Integer.parseInt(inputData[j]);
			}
		}
		
		calcMax();
		System.out.println(arr[0][0]);
	}

}
