package level5_1차원배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int caseNum, i, res, j, i2, sum = 0,avg =0,pi=0;
		
		caseNum= Integer.parseInt(br.readLine());
		String str;
		float[] per = new float[caseNum];
		
		for(i=0;i<caseNum;i++) {
			str=br.readLine();
			i2 = Integer.parseInt(str.split(" ")[0]);
			for(j=1;j<i2+1;j++) {
				sum+=Integer.parseInt(str.split(" ")[j]);
			}
			avg = sum/i2;
			for(j=1;j<i2+1;j++) {
				if(Integer.parseInt(str.split(" ")[j])>avg) {
					pi++;
				}
			}
			per[i]=(float) pi / (float) i2;
			pi=0;
			sum=0;
		}
		
		for(i=0;i<per.length;i++) {
			System.out.println(String.format("%.3f",per[i]*100) + "%");
		}
		
	}
}
