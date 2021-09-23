package package14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num9184 {
	static final int MAX = 20 + 1;
	
	static int[][][] dp = new int[MAX][MAX][MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String[] inputData = br.readLine().split(" ");
			int a = Integer.parseInt(inputData[0]);
			int b = Integer.parseInt(inputData[1]);
			int c = Integer.parseInt(inputData[2]);
			if(breakCondition(a,b,c)) {
				break;
			}
			if(checkValue(a,b,c)) {
				bw.write("w("+a+", "+b+", "+c+") = 1\n");
			}else {
				bw.write("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
			}
			
		}
		bw.flush();
		
	}
	public static int w(int a,int b,int c) {
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		else if (a > 20 || b > 20 || c > 20) 
			return w(20, 20, 20);
		else if (a < b && b < c)
		{
			if (dp[a][b][c] != 0) return dp[a][b][c];
			else return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		else
		{
			if (dp[a][b][c] != 0) return dp[a][b][c];
			else return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}
	}
	public static boolean checkValue(int a,int b,int c) {
		return a<=0 || b<=0 || c<= 0 ? true : false;
	}
	public static boolean breakCondition(int a,int b,int c) {
		return a==-1 && b==-1 && c==-1 ? true : false;
	}
}
