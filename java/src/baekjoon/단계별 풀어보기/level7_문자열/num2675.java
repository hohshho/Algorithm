package level7_문자열;

import java.util.Scanner;

public class num2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		x = sc.nextInt();
		String[] print = new String[x];
		for(int i=0;i<x;i++) {
			int index = sc.nextInt();
			String value = sc.nextLine();
			
			StringBuilder output = new StringBuilder();
			for(int j=1;j<value.length();j++) {
				for(int k=0;k<index;k++) {
					output.append(value.charAt(j));
				}
			}
			print[i]=output.toString();
			
		}
		for(String a : print) {
			System.out.println(a);
		}
		
	}
}
