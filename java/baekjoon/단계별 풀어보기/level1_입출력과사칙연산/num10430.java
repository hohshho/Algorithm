package level1_입출력과사칙연산;

import java.util.Scanner;

public class num10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C1,C2,C3;
		C1 = (int)(B/100);
		C2 = (int)(B/10-C1*10);
		C3 = (int)(B-C1*100-C2*10);
		System.out.println(A*C1);
		System.out.println(A*C2);
		System.out.println(A*C3);
		System.out.println(A*B);
	}
}
