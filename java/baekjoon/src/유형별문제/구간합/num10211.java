package 유형별문제.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//1
//2
//5 -7
public class num10211 {
	static int N, X, MAX;
	static int[] arr, pSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = stoi(br.readLine());
		
		for(int i=0; i<N; i++) {
			MAX = Integer.MIN_VALUE;
			X = stoi(br.readLine());
			String[] arrData = br.readLine().split(" ");
			arr = new int[X];
			pSum = new int[X+1];
			
			for(int j=0; j<X; j++) {
				arr[j] = stoi(arrData[j]);
				pSum[j+1] = Math.max(pSum[j], 0) + arr[j];
				MAX = MAX > pSum[j+1] ? MAX : pSum[j+1];
			}
			sb.append(MAX+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
