package 단계별풀어보기.level25_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num3273 {
	static int N, X, sum=0, s =0, e, result = 0; // s랑 e부터 설정해야 함
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		e = N-1;
		String[] input = br.readLine().split(" ");
		X = stoi(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = stoi(input[i]);
		}
		calcResult();
		
		System.out.println(result);
		
	}
	
	public static void calcResult() {
		Arrays.sort(arr);
		while(s < e) {
			sum = arr[s] + arr[e];
			if(sum == X) {
				result++;
			}
			
			if(sum <= X) {
				s++;
			}
			else {
				e--;
			}
		}
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
