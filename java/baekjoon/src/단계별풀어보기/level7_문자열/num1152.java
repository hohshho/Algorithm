package 단계별풀어보기.level7_문자열;

import java.util.Scanner;
import java.util.StringTokenizer;

public class num1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] array = str.split(" ");
		String[] temp = new String[2];
		StringBuilder builder = new StringBuilder();
		int[] value = new int[2];
		
		for(int j=0;j<2;j++) {
			for(int i=3;i>0;i--) {
				builder.append(array[j].charAt(i-1));
			}
			str = builder.toString();
			value[j] = Integer.parseInt(str);
			builder.delete(0,builder.length());
		}
		
		if(value[0]>value[1]) {
			System.out.println(value[0]);
		}else {
			System.out.println(value[1]);
		}
		
		
	}
}
