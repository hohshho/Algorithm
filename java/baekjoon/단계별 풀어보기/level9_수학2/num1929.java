package level9_수학2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num1929 {
	public static boolean go(int value) {
		if(value<2) return false;
		for(int i=2;i*i<=value;i++) {
			if(value%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		for(int i=a;i<=b;i++) {
			if(go(i)) {
				System.out.println(i);
			}
		}
	}
}
