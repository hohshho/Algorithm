package package16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1943 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		
		for(int i=0;i<N;i++) {
			String[] inputData = br.readLine().split(" ");
			int a=Integer.parseInt(inputData[0]);
			int b=Integer.parseInt(inputData[1]);
			result[i] = a * b / gcd(a,b);
		}
		
		for(int resultNum:result) {
			System.out.println(resultNum);
		}
	}
	public static int gcd(int a,int b) {
		return a % b == 0 ? b : gcd(b,a%b);
	}
}
