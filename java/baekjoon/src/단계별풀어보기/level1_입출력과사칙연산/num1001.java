package 단계별풀어보기.level1_입출력과사칙연산;

import java.util.Scanner;

public class num1001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int word1 = Integer.parseInt(num.split(" ")[0]);
		int word2 = Integer.parseInt(num.split(" ")[1]);
		System.out.println(word1 - word2);
		
	}
}