package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num3078 {
	static int N, K;
	static long cnt=0;
	static Queue[] qarr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		qarr = new Queue[21];
		for(int i=0; i<=20; i++) {
			qarr[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<N; i++) {
			int nowLen = br.readLine().length();
			
			if(qarr[nowLen].isEmpty()) {
				qarr[nowLen].offer(i);
			}else {
				while ((i - (int) qarr[nowLen].peek()) > K) {
					qarr[nowLen].poll();
					if (qarr[nowLen].isEmpty()) {
						break;
					}
				}
				cnt += qarr[nowLen].size();
				qarr[nowLen].offer(i);
			}
		}
		
		System.out.println(cnt);
	}
	
	static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
