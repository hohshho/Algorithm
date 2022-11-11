package level20_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num12015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] inputArrData = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i] = stoi(inputArrData[i]);
		}
		
		System.out.println(psearch(arr));
		
	}

	public static int psearch(int[] arr) {
		int start = 0;
		int end = arr.length;
		int index = 0;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(checkArr(arr,mid)) {
				index = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return index;
	}
	
	public static boolean checkArr(int[] arr, int mid) {
		int count=0;
		
		for(int j = 0; j<arr.length; j++) {
			int temp = arr[j];
			for(int i =j+1;i<arr.length;i++) {
				if(arr[i]>temp) {
					temp=arr[i];
					count++;
				}
				if(count>=mid-1)
					return true;
			}
		}
		return false;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
