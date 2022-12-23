package 단계별풀어보기.level11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1436 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int i = 0;
		int count = 0;
		int answer =0;
		
		while(count!=N) {
			i++;
			if(Integer.toString(i).contains("666")) {
				count++;
			}
		}
		
		System.out.println(i);
	}
}
