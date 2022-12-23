package 단계별풀어보기.level4_while문;

import java.io.IOException;
import java.util.Scanner;

public class num10951 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String data;
//		int[] num = new int[2];
//		num[0]=1; num[1]=1;
//		int i=0;
//		int res;
//		while(true) {
//			data = br.readLine();
//			
//			num[0]=Integer.parseInt(data.split(" ")[0]);
//			num[1]=Integer.parseInt(data.split(" ")[1]);
//			res = num[0]+num[1];
//			bw.write(String.valueOf(res)+"\n");
//			bw.flush();
//		}
		// iterator 사용
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			int a = s.nextInt();
			int b = s.nextInt();
			System.out.println(a+b);
		}
		
	}
}
