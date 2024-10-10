package 단계별풀어보기.level18_큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class num10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();

		for(int i=0; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			
			if(inputData[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(inputData[1]));
			}else if(inputData[0].equals("push_back")) {
				deque.addLast(Integer.parseInt(inputData[1]));
			}else if(inputData[0].equals("pop_front")) {
				if(!deque.isEmpty()) {
					sb.append(deque.pollFirst()+ "\n");
				}else {
					sb.append("-1\n");
				}
			}else if(inputData[0].equals("pop_back")) {
				if(!deque.isEmpty()) {
					sb.append(deque.pollLast()+ "\n");
				}else {
					sb.append("-1\n");
				}	
			}else if(inputData[0].equals("size")) {
				sb.append(deque.size()+ "\n");
			}else if(inputData[0].equals("empty")) {
				if(deque.isEmpty())
					sb.append(1+ "\n");
				else
					sb.append(0+ "\n");
			}else if(inputData[0].equals("front")) {
				if(!deque.isEmpty())
					sb.append(deque.getFirst()+ "\n");
				else
					sb.append(-1+"\n");
			}else if(inputData[0].equals("back")) {
				if(!deque.isEmpty())
					sb.append(deque.getLast()+ "\n");
				else
					sb.append("-1\n");				
			}
		}
		System.out.println(sb);
	}

}