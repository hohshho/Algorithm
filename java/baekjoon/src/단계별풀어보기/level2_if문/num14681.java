package 단계별풀어보기.level2_if문;

import java.util.Scanner;

public class num14681 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if(num1>0) {
			if(num2>0) {
				System.out.println("1");
			}else{
				System.out.println("4");
			}
		}else {
			if(num2>0) {
				System.out.println("2");
			}else {
				System.out.println("3");
			}
		}
	}
}
