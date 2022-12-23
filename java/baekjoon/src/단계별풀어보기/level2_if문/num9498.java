package 단계별풀어보기.level2_if문;

import java.util.Scanner;

public class num9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		if(100>=A &&A>=90) {
			System.out.println("A");
		}else if(89>=A &&A>=80) {
			System.out.println("B");
		}else if(79>=A &&A>=70) {
			System.out.println("C");
		}else if(69>=A &&A>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
