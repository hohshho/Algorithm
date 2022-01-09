package sumOfInterval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11659 {
	static int N, M;
	static int[] arr, pSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		
		arr = new int[N];
		pSum = new int[N+1];
		
		String[] arrData = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = stoi(arrData[i]);
			pSum[i+1] = arr[i] + pSum[i];
		}
		
		for(int i=0; i<M; i++) {
			String[] AB = br.readLine().split(" ");
			int a = stoi(AB[0])-1;
			int b = stoi(AB[1])-1;
			
			sb.append(pSum[b+1] - pSum[a] + "\n");
		}
		System.out.println(sb);
	}

	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
