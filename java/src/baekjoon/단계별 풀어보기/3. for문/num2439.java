package package3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num2439 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i,a,b;
		String data = br.readLine();
		
		int t = Integer.parseInt(data);

		for(i=1;i<t+1;i++) {
			for(b=1;b<t+1-i;b++) {
				bw.write(" ");
			}
			for(a=1;a<i+1;a++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
