package 단계별풀어보기.level29_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9372 {
	static int T, N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = stoi(br.readLine());
		
		for(int i=0; i<T; i++) {
			String[] NM = br.readLine().split(" ");
			N = stoi(NM[0]);
			M = stoi(NM[1]);
			
			for(int j=0; j<M; j++)
				br.readLine();
			
			sb.append(N-1+"\n");
		}
		System.out.println(sb.toString());
		
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
