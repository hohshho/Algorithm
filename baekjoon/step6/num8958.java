package package6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int i,j,caseNum,num=1;
		
		caseNum = Integer.parseInt(br.readLine());
		
		String[] arr = new String[caseNum];
		int[] score = new int[caseNum];
		String index="",dindex="";
		
		for(i=0;i<caseNum;i++) {
			arr[i] = br.readLine();
			String[] str = arr[i].split("");
			for(j=0;j<str.length;j++) {
				if(num==1&&str[j].equals("O")) {
					score[i]+=num;
					num++;
					continue;
				}
				index = str[j];
				if(str[j].equals("O")) {
					score[i]+=num;
					num++;
				}else {
					num=1;
				}
			}
			num=1;
		}
		
		for(i=0;i<score.length;i++) {
			System.out.println(score[i]);
		}
		
		
	}
}
