package 단계별풀어보기.level3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i,num,s=0;
		
		String nx = br.readLine();
		int n = Integer.parseInt(nx.split(" ")[0]);
		int x = Integer.parseInt(nx.split(" ")[1]);
		int[] result = new int[n];

		String data = br.readLine();
		String[] dataSplit = new String[n];
		
		for(i=0;i<n;i++) {
			 dataSplit[i]= data.split(" ")[i];
		}
		
		for(i=0;i<n;i++) {
			num=Integer.parseInt(dataSplit[i]);
			if(num<x) {
				result[s]=num;
				s++;
			}
		}
		
		for(i=0;i<s;i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}
