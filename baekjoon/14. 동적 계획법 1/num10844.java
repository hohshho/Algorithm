package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num10844 {

	static int[] dp;
	static int dpLen = 0;
	static int count =0;
	static void calc(int num, int depth) {
		if(depth==dpLen) {
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
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dpLen = dp.length-1;
		for(int i=1;i<10;i++) {
			calc(i,1);
		}
		
		System.out.println(count);
		
	}

}
