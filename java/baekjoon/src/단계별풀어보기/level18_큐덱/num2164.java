package 단계별풀어보기.level18_큐덱;

import java.util.LinkedList;
import java.util.Scanner;

public class num2164 {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while(queue.size()!=1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
		
	}

}
