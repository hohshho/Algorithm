package level3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num2742 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i;
		
		int num = Integer.parseInt(br.readLine());
		
		for(i=num;i>0;i--) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
}
