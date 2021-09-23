package package21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class num1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int value = Integer.parseInt(br.readLine());
			q.offer(value);
			int len = q.size()/2 + q.size()%2;
			Stack<Integer> s = new Stack<>();
			for(int j=0;j<len;j++) {
				s.push(q.remove());
			}
			if(!s.isEmpty())
				sb.append(s.peek()+"\n");
			while(!s.isEmpty()) {
				q.offer(s.pop());
			}
			
		}
		System.out.println(sb);
	}

}