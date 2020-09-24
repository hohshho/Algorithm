package package9;

import java.util.Scanner;

public class num1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int index = 0,line=0;
		int top,bottom;
		int count = 0;
		while(index<num) {
			line++;
			count=index;
			index+=line;
		}
		if(line%2==0) {
			// 짝수
			int di = num-count;
			bottom = line;
			top=1;
			for(int i=1;i<di;i++) {
				bottom--;
				top++;
			}
		}else {
			// 홀수
			int di = num-count;
			top=line;
			bottom=1;
			for(int i=1;i<di;i++) {
				bottom++;
				top--;
			}
		}
		System.out.println(top+"/"+bottom);
		
	}
}
