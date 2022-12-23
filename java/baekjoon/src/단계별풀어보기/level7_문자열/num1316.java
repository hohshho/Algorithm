package 단계별풀어보기.level7_문자열;

import java.util.Scanner;

public class num1316 {
	public static void main(String argsp[]) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String[] data = new String[num];
		int answer = num;
		int index = 0;
		int no =0;
		
		for(int i=0;i<num;i++) {
			data[i] = sc.next();
			int len = data[i].length();
			for(int j=0;j<len;j++) {
				for(int k=j;k<len;k++) {
					if(k!=j) {
						if(index == 0 && (data[i].charAt(j) != data[i].charAt(k))) {
							index =1;
						}
						if(index ==1 && (data[i].charAt(j) == data[i].charAt(k))) {
							no = 1;
							break;
						}
					}
				}
				index =0;
				if(no==1) {
					answer--;
					no=0;
					break;
				}
			}
		}
		System.out.println(answer);
		
	}
}
