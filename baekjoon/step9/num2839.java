package package9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num2839 {

	public static void main(String[] args) throws IOException {
		int A =0,B=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = Integer.parseInt(br.readLine());
		int count =0;
		while(true) {
			if(data%5==0 && data%3==0) {
				data-=5;
				count++;
			}else if(data % 5==0) {
				data-=5;
				count++;
			}else if(data % 3 ==0) {
				data-=3;
				count++;
			}else {
				data-=5;
				count++;
			}
			if(data<0) {
				break;
			}
			if(data==0) {
				break;
			}
		}
		if(data<0) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
		
	}

}
