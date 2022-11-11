package level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num2609 {
	public static boolean calc(int value,int index) {
		if(value!=1 && value%index == 0) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1,num2;
		String[] inputData = br.readLine().split(" ");
		num1 = Integer.parseInt(inputData[0]);
		num2 = Integer.parseInt(inputData[1]);
		
		int index = 1;
		int result1 = 1;
		int result2 = 1;
		while(num1!=1 || num2!=1) {
			index++;
			if(calc(num1,index)) {
				num1/=index;
				if(calc(num2,index)) {
					num2/=index;
					result1*=index;
					result2*=index;
					index =1;
					continue;
				}
				result2*=index;
				index =1;
			}
			if(calc(num2,index)) {
				num2/=index;
				result2*=index;
				index=1;
			}
			
		}
		System.out.println(result1);
		System.out.println(result2);
	}

}
