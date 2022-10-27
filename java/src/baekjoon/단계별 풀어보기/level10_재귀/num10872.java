package level10_재귀;

import java.io.*;

public class num10872 {
	public static int fac(int N) {
		if(N<1) {
			return 1;
		}
		return N*fac(N-1);
	}
	public static void main(String[] args) {
		int answer = fac(10);
		System.out.println(answer);
	}
}
