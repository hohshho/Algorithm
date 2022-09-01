import java.util.Scanner;

public class num1000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int word1 = Integer.parseInt(num.split(" ")[0]);
		int word2 = Integer.parseInt(num.split(" ")[1]);
		System.out.println(word1 + word2);
		
	}
}