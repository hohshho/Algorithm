package package16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11050 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		int N = Integer.parseInt(inputData[0]);
		int K = Integer.parseInt(inputData[1]);
		
		System.out.println(combination(N, K));
		
		
		
	}
	public static int combination(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return combination(n - 1, r - 1) + combination(n - 1, r); 
	}
}
