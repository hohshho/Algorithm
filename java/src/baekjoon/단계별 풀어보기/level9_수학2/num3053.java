package level9_수학2;

import java.util.Scanner;

public class num3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R=sc.nextInt();
		
		String res1 = String.format("%.6f", Math.PI*R*R);
		String res2 = String.format("%.6f", (double)2*R*R);
		
		System.out.println(res1);
		System.out.println(res2);
	}
}
