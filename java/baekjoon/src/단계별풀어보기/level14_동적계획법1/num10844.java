package 단계별풀어보기.level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num10844 {

	static int[] arr;
	static int N;
	static Long count =0L;
	static void calc(int num, int depth) {
		if(depth==N) {
			count++;
			return;
		}
		if(num+1<10) {
			calc(num+1,depth+1);
		}
		if(num-1>=0) {
			calc(num-1,depth+1);
		}
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<10;i++) {
			calc(i,1);
		}
		
		System.out.println(count);
		
	}

}
