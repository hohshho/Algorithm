package pakcage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] inputData = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i] = StringToInt(inputData[i]);
		}
		
		Arrays.sort(arr);
		int M = StringToInt(br.readLine());
		inputData = br.readLine().split(" ");
		
		for(int i=0;i<M;i++) {
			int value = StringToInt(inputData[i]);
			sb.append(Bsearch(value,arr,0,arr.length)+"\n");
		}
		System.out.println(sb);
	}
	public static int Bsearch(int value, int[] arr,int start, int finish) {
        int left = start;
        int right = finish - 1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            int midValue = arr[midIndex];
            if (midValue > value) {
                right = midIndex - 1;
            } else if (midValue < value) {
                left = midIndex + 1;
            } else { 
                return 1;
            }
        }
        return 0; 
		
	}
	public static int StringToInt(String input) {
		return Integer.parseInt(input);
	}
}
