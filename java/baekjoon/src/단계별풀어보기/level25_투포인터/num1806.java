package 단계별풀어보기.level25_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1806 {
	static int INF = Integer.MAX_VALUE;
	static int N, S, result=INF, sum = 0, s = 0, e = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NS = br.readLine().split(" ");
		N = stoi(NS[0]);
		S = stoi(NS[1]);
		arr = new int[N];
		
		String[] inputArr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = stoi(inputArr[i]);
		}
		
		calcCount();
		
		result = result == INF ? 0 : result;
		System.out.println(result);
	}
	
	public static void calcCount() {
		while(true) {
			if(sum >= S) {
				sum-=arr[s++];
				result = Math.min(result, (e-s)+1);
			}else if(e == N) break;
			else sum+=arr[e++];
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
