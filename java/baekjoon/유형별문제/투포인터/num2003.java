package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2003 {
	static int N, M, count = 0, s=0, e=0, sum = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		arr = new int[N];
		
		String[] arrData = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = stoi(arrData[i]);
		}
		
		calcCount();
		
		System.out.println(count);
	}
	
	public static void calcCount() {
		   while(true){
		        if(sum >= M) sum -= arr[s++];
		        else if(e == N) break;
		        else sum += arr[e++];
		        if(sum == M) count++;
		    }
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
