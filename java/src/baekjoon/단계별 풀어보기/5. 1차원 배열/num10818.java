package package6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num, score, max=0,min=1000000,i;
		String data;
		num = Integer.parseInt(br.readLine());
		data = br.readLine();
		StringTokenizer stk = new StringTokenizer(data);
			
//		for(i=0;i<num;i++) {
//			score = Integer.parseInt(data.split(" ")[i]);
//			if(i==0) {
//				max = score;
//				min = score;
//			}
//			if(max<score) {
//				max = score;
//			}
//			if(min>score) {
//				min = score;
//			}
//		}
//		bw.write(String.valueOf(min)+ " " + String.valueOf(max));
		
		while(stk.hasMoreTokens()) {
			score = Integer.parseInt(stk.nextToken());
			
			if(score< min)
				min = score;
				
			if(score>max)
				max = score;
		}
		bw.write(min + " " + max);
		bw.flush();
		bw.close();
		//scanf로 다시짜야 함
//		Scanner sc = new Scanner(System.in);
//		int x,num,i,max = 0,min =0;
//		num = sc.nextInt();
//		for(i=0;i<num;i++) {
//			x=sc.nextInt();
//			if(i==0) {
//				max = x;
//				min = x;
//			}
//			if(x>max) {
//				max = x;
//			}
//			if(x<min) {
//				min=x;
//			}
//		}
//		System.out.println(min + " " + max);
	}
}
