package 단계별풀어보기.level7_문자열;

import java.util.Scanner;

public class num1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[26];
		String data = sc.nextLine();
		int dataLen = data.length();
		int max=0;
		int index=0;
		int same = 0;
		
		for(int i=0;i<dataLen;i++) {
			int value = data.charAt(i);
			if(value>=97) {
				array[value-97]++;
			}else {
				array[value-65]++;
			}
		}
		
		for(int i=0;i<array.length;i++) {
			if(array[i]==max) {
				same=1;
			}
			if(array[i]>max) {
				max=array[i];
				index=i;
				same=0;
			}
		}
		int answer = index+65;
		if(same==0) {
			System.out.println((char)answer);
		}else {
			System.out.println("?");
		}
		
		
	}
}
