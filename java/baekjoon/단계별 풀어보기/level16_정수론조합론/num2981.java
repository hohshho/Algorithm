package level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int arrGcdValue = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<N; i++) {
			arrGcdValue = gcd(arrGcdValue, Math.abs(arr[i] - arr[i-1]));
		}
		
		for(int i=2; i<=arrGcdValue; i++) {
			if(arrGcdValue % i == 0)
				System.out.print(i + " ");
		}
	}
	
	public static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

}
