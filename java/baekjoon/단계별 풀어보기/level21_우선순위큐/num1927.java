package level21_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int value = Integer.parseInt(br.readLine());
			if(value!=0)
				q.offer(value);
			else {
				if(!q.isEmpty()) {
					sb.append(q.poll());
				}else {
					sb.append("0");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}