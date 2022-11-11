package level11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][2];
		int[] rank = new int[N];
		int index = 1;
		
		for(int i=0;i<N;i++) {
			String[] data = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(data[0]);
			list[i][1] = Integer.parseInt(data[1]);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(list[i][0]<list[j][0] && list[i][1]<list[j][1]) {
					index++;
				}
			}
			rank[i] = index;
			index =1;
		}
		for(int i=0;i<N;i++) {
			System.out.print(rank[i] + " ");
		}
		
	}
}
