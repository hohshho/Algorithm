package package8;

import java.util.Scanner;

public class num2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String input = sc.next();
		
		for(int i=0; i<8; i++) {
			input = input.replace(croatia[i],"a");
		}
		System.out.println(input.length());
	}
}
