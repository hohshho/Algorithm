package package12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num1724 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] cntArr = new int[10];
		
		while(N>0) {
			cntArr[N%10]++;
			N/=10;
		}
		
		for(int i=9;i>=0;i--) {
			while(cntArr[i]!=0) {
				sb.append(i);
				cntArr[i]--;
			}
		}
		System.out.println(sb);
		
	}
}
