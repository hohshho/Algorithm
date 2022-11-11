package level20_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputNK = br.readLine().split(" ");
		int N = Integer.parseInt(inputNK[0]);
		long K = Long.parseLong(inputNK[1]);
		long max = 0;
		
		long[] houseArr = new long[N];
		
		for(int i=0; i<N; i++) {
			houseArr[i] = Long.parseLong(br.readLine());
			max = max > houseArr[i] ? max : houseArr[i];
		}
		Arrays.sort(houseArr);
		
		max = Psearch(houseArr, K, max);
		System.out.println(max);
	}
	
	public static long Psearch(long[] houseArr, long K, long max) {
		long start = 1;
		long end = max;
		long ans = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			
			if(checkHouse(houseArr, mid, K)) {
				start = mid+1;
				ans = ans > mid ? ans : mid;
			}else {
				end = mid-1;
			}
		}
		return ans;
	}
	
	public static boolean checkHouse(long[] houseArr, long mid, long K) {
		long temp = houseArr[0];
		long index = 0;
		for(int i = 1; i<houseArr.length; i++) {
			if(houseArr[i]-temp >= mid) {
				index++;
				temp=houseArr[i];
			}
		}
		
		if(index >=K-1)
			return true;
		else
			return false;
	}

}
