package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2096 {
	static int N, MAX, MIN;
	static int[] tempMaxDp, tempMinDp, maxDp, minDp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		tempMaxDp = new int[3]; tempMinDp = new int[3]; maxDp = new int[3]; minDp = new int[3];
		
		for(int i=0; i<N; i++) {
			String[] step = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				tempMinDp[j] = tempMaxDp[j] = stoi(step[j]);
				tempMaxDp[j] += Math.max(maxDp[1] , j == 1 ? Math.max(maxDp[0], maxDp[2]) : maxDp[j]);
				tempMinDp[j] += Math.min(minDp[1] , j == 1 ? Math.min(minDp[0], minDp[2]) : minDp[j]);
				MAX = j==0 ? tempMaxDp[j] : MAX > tempMaxDp[j] ? MAX : tempMaxDp[j];
				MIN = j==0 ? tempMinDp[j] : MIN < tempMinDp[j] ? MIN : tempMinDp[j];
			}
			arrayCopy(maxDp, tempMaxDp);
			arrayCopy(minDp, tempMinDp);
			
		}
		System.out.println(MAX + " " + MIN);
	}
	
	public static void arrayCopy(int[] to, int[] from) {
		for(int i=0; i<3; i++) {
			to[i] = from[i];
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
