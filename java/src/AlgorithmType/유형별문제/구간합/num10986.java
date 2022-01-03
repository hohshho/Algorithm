package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num10986 {
	static long N, M, ans;
	static long[] cnt, pSum;
	static final int MAX = 1000000 + 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = stol(NM[0]);
		M = stol(NM[1]);
		cnt = new long[(int)M];
		pSum = new long[(int)N+1];
		
		String[] arrData = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			long num = stol(arrData[i-1]);
			pSum[i] = (pSum[i - 1] + num) % M;
			cnt[(int) pSum[i]]++;
			if(pSum[i] == 0) ans++;
		}
		
		for(int i = 0 ; i < M ; ++i) {
			ans += cnt[i] * (cnt[i] - 1) / 2;
		}
		System.out.println(ans);
	}
	public static long stol(String string) {
		return Long.parseLong(string);
	}

}
