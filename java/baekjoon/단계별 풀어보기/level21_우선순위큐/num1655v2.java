package level21_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class num1655v2 {

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
			if(i==0) {
				index = num;
				sb.append(num+"\n");
				continue;
			}
			if(num<=index) {
				// 작은 값이면 max heap에 저장
				max.offer(num);
				if(max.size()-min.size()>=1) {
					min.offer(index);
					index = max.poll();
				}
			}else {
				// 큰 값이면  min heap에 저장
				min.offer(num);
				if(min.size() - max.size() >=2) {
					max.offer(index);
					index = min.poll();
				}
			}
			sb.append(index+"\n");
		}
		System.out.println(sb);
	}

}
