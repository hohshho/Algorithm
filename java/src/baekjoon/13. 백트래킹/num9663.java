package package13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num9663 {
	public static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		dfs(arr,0,N);
		System.out.println(cnt);
	}
	
	public static void dfs(int[] arr, int depth,int N) {
		if(N==depth) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[depth] = i;
			if(isPossible(arr, depth)) {
				dfs(arr,depth+1,N);
			}
		}
		
	}
	
	public static boolean isPossible(int[] arr, int value) {
		
		for(int i=0;i<value;i++) {
			if(arr[i] == arr[value])
				return false;
			if(Math.abs(value-i) == Math.abs(arr[value]-arr[i]))
				return false;
		}
		
		return true;
	}
}
