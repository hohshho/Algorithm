package 유형별문제.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a,b,c;
		String[] inputData = br.readLine().split(" ");
		a= Integer.parseInt(inputData[0]);
		b= Integer.parseInt(inputData[1]);
		c= Integer.parseInt(inputData[2]);
		
		System.out.println(pow(a,b,c));
	}
	public static long pow(long a,long b,long c) {
		if(b==1)
			return a%c;
		long val = pow(a,b/2,c);
		val = val * val % c;
		if(b%2 == 0) return val;
		return val * a % c;
	}

}
