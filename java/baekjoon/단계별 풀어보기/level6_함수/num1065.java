package level6_함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1065 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		int count= 99;
		
		num = Integer.parseInt(br.readLine());
		
		if(num<111) {
			if(num<100) {
				System.out.println(num);
			}else {
				System.out.println("99");
			}
		}else {
			// 함수 부름
			System.out.println(count + han(num));
		}
		
	}
	public static int han(int data) {
		int x,y;
		int i=0;
		int count=0;
		int num=100;
		int[] arr = new int[3];
		while(true) {
			arr[2]=num%10;
			arr[1]=(num/10)%10;
			arr[0]=num/100;
			if(arr[0] - arr[1] == arr[1] - arr[2]) {
				count++;
			}
			if(num>=data) {
				break;
			}
			num++;
		}
		return count;
	}
}
