package level5_1차원배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int i,num,count=0,arrNum;
		int[] arr = new int[42];
		
		for(i=0;i<10;i++) {
			num = Integer.parseInt(br.readLine());
			arrNum = num%42;
//			System.out.println(arrNum);
			arr[arrNum]+=1;
		}
		
		for(i=0;i<42;i++) {
			if(arr[i]!=0) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}
