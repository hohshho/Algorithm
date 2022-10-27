package level3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num15552 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		String data = bf.readLine();
		int i;
		int a;
		int x = Integer.parseInt(data);
		System.out.println(x);
		
		int [][] num = new int[x][2];
		
		for(i=0;i<x;i++) {
			data = bf.readLine();
			String st = data;
			num[i][0] = Integer.parseInt(st.split(" ")[0]);
			num[i][1] = Integer.parseInt(st.split(" ")[1]);
			bw.write((num[i][0]+num[i][1]) + "\n");
		}
		bw.close();
	}
}
