package 단계별풀어보기.level10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num10870 {
	public static int fi(int N) {
		if(N<=1) return N;
		return fi(N-1) + fi(N-2);
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = fi(N);
		System.out.println(answer);
	}
}
