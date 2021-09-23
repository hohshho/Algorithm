package package9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class num2581 {
	public static boolean go(int value) {
		if(value<2) return false;
		for(int i=2;i*i<=value;i++) {
			if(value%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int sum=0;
		int min=10001;
		for(int i=a;i<=b;i++) {
			if(go(i)) {
				sum+=i;
				if(min>i) {
					min = i;
				}
			}
		}
		if(sum==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}
