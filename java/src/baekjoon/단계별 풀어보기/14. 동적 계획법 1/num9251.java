package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");
		
		int N = str1.length;
		int M = str2.length;
		int[][] arr = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(str1[i-1].equals(str2[j-1])) {
					arr[i][j] = arr[i-1][j-1] +1;
				}else {
					arr[i][j] = Math.max(arr[i][j-1],arr[i-1][j]);
				}
			}
		}
		System.out.println(arr[N][M]);
	}
}
