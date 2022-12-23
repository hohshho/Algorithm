package 단계별풀어보기.level12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class num11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] output = new int[N][2];
		for(int i=0;i<N;i++) {
			String[] inputData = br.readLine().split(" ");
			output[i][0] = Integer.parseInt(inputData[0]);
			output[i][1] = Integer.parseInt(inputData[1]);
		}
		
		Arrays.sort(output,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		for(int i=0;i<N;i++) {
			sb.append(output[i][0] + " " + output[i][1] + "\n");
		}
		System.out.println(sb);
	}
}
