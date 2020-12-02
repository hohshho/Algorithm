package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num10844 {

	static int[] dp;
	static int count =0;
	static void calc(int num, int depth) {
		if(depth==dp.length-1) {
			count++;
			return;
		}
		dp[depth] = num;
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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		for(int i=1;i<10;i++) {
			calc(i,1);
		}
		
		System.out.println(count);
		
	}

}
