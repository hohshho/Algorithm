package level3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num11021 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i;
		int t = Integer.parseInt(br.readLine());
		int[][] num = new int[t][2];
		String sc;
		
		for(i=0;i<t;i++) {
			sc = br.readLine();
			num[i][0] = Integer.parseInt(sc.split(" ")[0]);
			num[i][1] = Integer.parseInt(sc.split(" ")[1]);
			bw.write("Case #"+ (i+1) +": " + (num[i][0]+num[i][1]) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
