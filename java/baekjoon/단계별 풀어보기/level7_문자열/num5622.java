package level7_문자열;

import java.util.Scanner;

public class num5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String data = sc.nextLine();
		int dataLen = data.length();
		int index =0;
		int value =0;
		int total = 0;
		for(int i=0; i<dataLen; i++) {
			index=data.charAt(i) - 'A';
			if(index >17) {
				if(index == 18) {
					value = 5;
				}else {
					if(index>21) {
						value=7;
					}else {
						value=6;
					}
				}
			}else {
				value=index/3;
			}
			total+=(value+3);
		}
		System.out.println(total);
	}
}
