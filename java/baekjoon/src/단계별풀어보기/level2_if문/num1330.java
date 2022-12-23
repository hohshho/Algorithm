package 단계별풀어보기.level2_if문;

import java.util.Scanner;

public class num1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if(A>B) {
			System.out.println(">");
		}else if(A==B) {
			System.out.println("==");
		}else {
			System.out.println("<");
		}
	}
}
