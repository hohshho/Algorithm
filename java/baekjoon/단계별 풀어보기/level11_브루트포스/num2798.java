package level11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NMdata = br.readLine().split(" ");
		
		int N = Integer.parseInt(NMdata[0]);
		int M = Integer.parseInt(NMdata[1]);
		
		int[] list = new int[N];
		String[] card = br.readLine().split(" ");
		
		int sum = 0;
		int max = 0;
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(card[i]);
		}
		
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					sum = list[i]+list[j]+list[k];
					if(sum<=M&&sum>max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
