package pakcage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		int N = Integer.parseInt(inputData[0]);
		long K = Integer.parseInt(inputData[1]);
		long[] arr = new long[N];
		long max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = max > arr[i] ? max : arr[i];
		}
		max = Bsearch(arr, K, max);
		System.out.println(max);
	}
	
	public static long Bsearch(long[] arr, long K, long max) {
		long start = 1;
		long end = max;
		long returnValue=0;
		while(start<=end) {
			long mid = (start+end)/2;
			int N = 0;
			for(int i=0;i<arr.length;i++) {
				N+=arr[i]/mid;
			}
			if(N>=K) {
				returnValue = Math.max(returnValue,mid);
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return returnValue;
	}
}
