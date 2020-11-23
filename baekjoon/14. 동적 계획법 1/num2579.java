package package14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] value = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=0; i<N; i++) {
			value[i+1] = Integer.parseInt(br.readLine());
		}
		
		if(N==0) {
			System.out.println(0);
		}else if(N<2){
			System.out.println(value[N]);
		}else {
		
			for(int i=N; i>0;i--) {
			
			}
		}
		
	}
}
