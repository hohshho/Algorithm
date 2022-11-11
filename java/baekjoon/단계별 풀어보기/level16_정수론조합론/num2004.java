package level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		int N = Integer.parseInt(inputData[0]);
		int M = Integer.parseInt(inputData[1]);
		
		long five = five_n(N) - five_n(N - M) - five_n(M);
		long two = two_n(N) - two_n(N-M) - two_n(M);
		
		System.out.println(Math.min(five,two));
		
	}
	
	public static long five_n(int num) {
		long count = 0;
		
		while(num>=5) {
			count += (num/5);
			num /=5;
		}
		return count;
	}
	public static long two_n(int num) {
		long count = 0;
		
		while(num>=2) {
			count += (num/2);
			num /=2;
		}
		return count;
	}
	
}
