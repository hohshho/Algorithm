package package3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num15552token {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		String data = bf.readLine();
		StringTokenizer st = new StringTokenizer(data);
		
		int i;
		int a;
		int x = Integer.parseInt(st.nextToken());
		int [][] num = new int[x][2];
		
		for(i=0;i<x;i++) {
			data = bf.readLine();
			st = new StringTokenizer(data);
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(i=0;i<x;i++) {
			bw.write((num[i][0]+num[i][1]) + "\n");
			bw.flush();
		}
		bw.close();
	}
}
