package package9;

import java.util.Scanner;

public class num2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		int index = 1;
		int answer = 1;
		
		while(true) {
			if(data>index) {
				index+=(answer*6);
				answer++;
			}else {
				break;
			}
		}
		if(data==1) {
			System.out.println(1);
		}else {
			System.out.println(answer);
		}
	}

}
