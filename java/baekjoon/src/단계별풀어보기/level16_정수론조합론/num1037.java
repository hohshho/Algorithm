package 단계별풀어보기.level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int min = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		String[] data = br.readLine().split(" ");
		int[] arr = new int[n+1];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(data[i]);
			if(i==0) {
				max = arr[i];
				min = arr[i];
			}
			max = arr[i]>max ? arr[i] : max;
			min = arr[i]<min ? arr[i] : min;
		}
		
		
		System.out.println(max*min);
		
	}

}
