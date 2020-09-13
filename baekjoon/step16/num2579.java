package package16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num2579 {
	public static int maxCostStairs(int[] cost) {
		
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cost = new int[N];
		
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = maxCostStairs(cost);
		
		
		System.out.println(answer);
	}
}
