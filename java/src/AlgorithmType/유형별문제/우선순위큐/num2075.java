package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num2075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				int cur = stoi(inputData[j]);
				if(queue.size()<N) {
					queue.add(cur);
				}else {
					if(queue.peek()<cur) {
						queue.remove();
						queue.add(cur);
					}
				}
				
			}
		}
		
		System.out.println(queue.peek());
	}

	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
