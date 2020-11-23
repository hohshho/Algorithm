package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15651 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		int n = Integer.parseInt(inputData[0]);
		int r = Integer.parseInt(inputData[1]);
		int[] output = new int[r];
		
		
		permutation(output, 0,n,r);
		System.out.print(sb);
	}
	
	static void permutation(int[] output,int depth, int n, int r) {
		if(depth == r) {
			printOutput(output);
			return;
		}
		
		for(int i=0;i<n;i++) {
				output[depth] = i+1;
				permutation(output,depth+1,n,r);

		}
		return;
	}
	static void printOutput(int[] output) {
		for(int i=0;i<output.length; i++) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
	
}
