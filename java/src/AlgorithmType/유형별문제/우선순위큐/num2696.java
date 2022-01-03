package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class num2696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int count = Integer.parseInt(br.readLine());
			String[] inputData = br.readLine().split(" ");
			sb.append(count/2+count%2 + "\n");
			int index = 0;
			int jindex = 0;
			for(int j=0; j<count; j++) {
				if(j%10==0 && j>9) {
					inputData = br.readLine().split(" ");
					if(j%20==0) {
						sb.append("\n");
					}
					jindex=0;
				}
				int num = Integer.parseInt(inputData[jindex]);
				if(jindex==0 && j==0) {
					jindex++;
					index = num;
					sb.append(num + " ");
					continue;
				}
				if(num <= index) {
					maxHeap.offer(num);
					if(maxHeap.size() - minHeap.size()>=1) {
						minHeap.offer(index);
						index = maxHeap.poll();
					}
				}else {
					minHeap.offer(num);
					if(minHeap.size() - maxHeap.size()>=2) {
						maxHeap.offer(index);
						index = minHeap.poll();
					}
				}
				if(jindex%2==0) {
					sb.append(index + " ");
				}
				jindex++;
			}
			
			sb.append("\n");
			minHeap.clear();
			maxHeap.clear();
		}
		System.out.println(sb);
	}

}
