package package9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int V = Integer.parseInt(stk.nextToken());
		int day = 0;
		V-=A;
		if(V%(A-B) == 0) {
			day+=V/(A-B);
		}else {
			day+=V/(A-B)+1;
		}
		
		System.out.println(day+1);
	}
}
