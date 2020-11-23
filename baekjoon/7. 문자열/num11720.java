package package8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numCase = Integer.parseInt(br.readLine());
		int[] num = new int[numCase];
		int i,sum=0;
		String data = br.readLine();
		for(i=0;i<numCase;i++) {
			sum+=Integer.parseInt(data.split("")[i]);
		}
		System.out.println(sum);
		
	}
}
