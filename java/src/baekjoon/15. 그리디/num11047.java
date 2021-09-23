package package15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11047 {

	static int N,K;
	static int[] coins;
	static int count=0;
	public static void calcCoinNum(int depth,int value) {
		if(value<=0) {
			return;
		}
		int data = value;
		int index = value/coins[depth];
		if(index > 0) {
			count+=index;
			data=value-(coins[depth]*index);
		}
		
		if(data>=0) {
			calcCoinNum(depth-1,data);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputData = br.readLine().split(" ");
		N = Integer.parseInt(inputData[0]);
		K = Integer.parseInt(inputData[1]);
		coins = new int[N];
		
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		calcCoinNum(coins.length-1,K);
		
		System.out.println(count);
	}

}
