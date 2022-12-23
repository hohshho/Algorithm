package 단계별풀어보기.level2_if문;

import java.util.Scanner;

public class num2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if(num2>=45) {
			num2 -=45;
			System.out.println(num1 + " " + num2);
		}else {
			num1 -=1;
			num2 +=15; 
			System.out.println(num1 + " " + num2);
		}
	}
}
