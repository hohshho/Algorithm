package package15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		String[] data = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(data[i]);
		}
		Arrays.sort(arr);
		int sum = arr[0];
		for(int i=1;i<n;i++) {
			arr[i] = arr[i] + arr[i-1];
			sum+=arr[i];
		}
		
		System.out.println(sum);
	}

}
