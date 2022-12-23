package 단계별풀어보기.level4_while문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class num10952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String data;
		int[] num = new int[2];
		num[0]=1; num[1]=1;
		int i=0;
		ArrayList list = new ArrayList<Integer>();

		while(true) {
			data = br.readLine();
			
			num[0]=Integer.parseInt(data.split(" ")[0]);
			num[1]=Integer.parseInt(data.split(" ")[1]);
			
			list.add(num[0]+num[1]);
			// bw 사용한 출력
			for(i=0;i<list.size();i++) {
				bw.write((int) list.get(i) + "\n");	
			}
			
			bw.flush();
		}
		

//		Scanner s = new Scanner(System.in);
//		
//		while(s.hasNextInt()) {
//			int a = s.nextInt();
//			int b = s.nextInt();
//			
//			System.out.println(a+b);
//		}
	}
}
