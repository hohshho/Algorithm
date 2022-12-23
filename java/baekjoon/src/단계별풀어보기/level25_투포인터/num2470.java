package 단계별풀어보기.level25_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2470 {
	static int N, s = 0, e, sum = 0, min = Integer.MAX_VALUE;
	static int[] arr, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		e = N-1;
		arr = new int[N];
		result = new int[2];
		
		String[] inputData = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = stoi(inputData[i]);
		}
		Arrays.sort(arr);
		
		getResult();
		
		System.out.println(result[0] + " " + result[1]);
	}
	
	public static void getResult() {
		while(s < e) {
			sum = arr[s] + arr[e];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				result[0] = arr[s];
				result[1] = arr[e];
			}
			if(sum > 0) e--;
			else s++;
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
