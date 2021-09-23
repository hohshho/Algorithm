package package15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1541 {
	static int calc(String data) {
		int value = 0;
		
		String[] arr = data.split("\\+");
		
		for(int i=0;i<arr.length;i++) {
			value+=Integer.parseInt(arr[i]);
		}
		
		return value;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputData = br.readLine().split("-");
		int sum = calc(inputData[0]);;
		
		for(int i=1;i<inputData.length;i++) {
			sum-=calc(inputData[i]);
		}
		
		System.out.println(sum);
	}

}
