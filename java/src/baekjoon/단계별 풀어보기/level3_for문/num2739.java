package level3_for문;

import java.util.Scanner;

public class num2739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i;
		for(i=1;i<10;i++) {
			System.out.println(num+" * "+i+" = "+(num*i));
		}
	}
}
