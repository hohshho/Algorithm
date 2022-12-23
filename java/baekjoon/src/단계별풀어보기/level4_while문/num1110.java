package 단계별풀어보기.level4_while문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num1110 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		int num = 0;
		int x1=0,x2=0;
		int im=0;
		int res = 0;
		int no = 10;
		num = Integer.parseInt(br.readLine());
		while(num != res) {
			if(count==0) {
				res=num;
			}
			if(res>=10) {
				x1=res/10;
				x2=res-(x1*10);
				im = x1+x2;
				res = x2*10 + (im%10);
				System.out.println(res);
			}else {
				x1=0;
				x2=res;	
				im = x1+x2;
				res = x2*10 + im;
				System.out.println(res);
			}
			if(res!=num) {
				count++;
			}
		}
		System.out.println(count+1);
	}
}
