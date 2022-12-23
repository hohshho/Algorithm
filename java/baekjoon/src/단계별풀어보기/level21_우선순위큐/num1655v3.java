package 단계별풀어보기.level21_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class num1655v3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> min = new PriorityQueue<>();
		Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
			
		});
		
		int T = Integer.parseInt(br.readLine());
		
		int index=0;
		
		for(int i = 0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			if(max.size() == min.size()) {
				max.offer(num);
				if(!min.isEmpty() && max.peek() > min.peek()) {
					min.offer(max.poll());
					max.offer(min.poll());
				}
			}else {
				min.offer(num);
				if(max.peek() > min.peek()) {
					min.offer(max.poll());
					max.offer(min.poll());
				}
			}
			sb.append(max.peek()+"\n");
		}
		System.out.println(sb);
	}
}
