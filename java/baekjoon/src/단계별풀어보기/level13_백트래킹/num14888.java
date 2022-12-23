package 단계별풀어보기.level13_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num14888 {
	static int max = -1000000000;
	static int min = 1000000000;
	static int N;
	static int[] numArr;
	static int[] signArr = new int[4];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		int[] visited = new int[N];
		
		String[] numArrString = br.readLine().split(" ");
		String[] signArrString = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			numArr[i] = Integer.parseInt(numArrString[i]);
		}
		for(int i=0;i<4;i++) {
			signArr[i] = Integer.parseInt(signArrString[i]);
		}
		
		bfs(1,numArr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void bfs(int depth, int value) {
		if(depth == N) {
			if(value>max)
				max = value;
			if(value<min)
				min = value;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(signArr[i]!=0) {
				signArr[i]--;
				if(i==0)
					bfs(depth+1,value + numArr[depth]);
				if(i==1)
					bfs(depth+1,value - numArr[depth]);
				if(i==2)
					bfs(depth+1,value * numArr[depth]);
				if(i==3)
					bfs(depth+1,value / numArr[depth]);
				signArr[i]++;
			}
		}
		
		
	}
}
