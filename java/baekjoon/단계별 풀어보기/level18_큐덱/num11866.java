package level18_큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num11866 {

	public static Queue<Integer> queue = new LinkedList<>();
	public static Queue<Integer> rQueue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		int N = Integer.parseInt(inputData[0]);
		int K = Integer.parseInt(inputData[1]);
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		sb.append("<");
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j % K == 0) {
					count++;
					sb.append(queue.poll());
					if(count != N)
						sb.append(", ");
				}else {
					queue.add(queue.poll());
				}
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}


}
