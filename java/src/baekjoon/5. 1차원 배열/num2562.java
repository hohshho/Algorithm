package package6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count=0,num,max=0,x=0;
		
		while(count<9) {
			num = Integer.parseInt(br.readLine());
			if(max<num) {
				x=count+1;
				max=num;
			}
			count ++;
		}
		
		bw.write(max+ "\n"+ x);
		bw.flush();
		bw.close();
	}
}
