package level1_입출력과사칙연산;

import java.util.Scanner;

public class num10998 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String box = sc.nextLine();
		int num1 = Integer.parseInt(box.split(" ")[0]);
		int num2 = Integer.parseInt(box.split(" ")[1]);
		System.out.println(num1 * num2);
	}
}
