package 단계별풀어보기.level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num12865v2 {

	static boolean[] dp;
	static int N,K;
	static int max = 0;
	static int[][] items;
	static void check(int depth,int weight,int value) {
		if(depth >= N) {
			return;
		}
		if(value>max)
			max=value;
		for(int i=0;i<N;i++) {
			if(weight+items[i][0]<=K) {
				check(i+1,weight+items[i][0],value + items[i][1]);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		dp = new boolean[N];
		items = new int[N][2];
		
		for(int i=0;i<N;i++) {
			String[] inputData = br.readLine().split(" ");
			items[i][0] = Integer.parseInt(inputData[0]);
			items[i][1] = Integer.parseInt(inputData[1]);
		}
		
		check(0,0,0);
		
		System.out.println(max);
		
	}

}
