package programmers;

import java.util.*;

public class type2ex2ver2 {
	public static void main(String[] args) {
		int[] progresses = new int[] {};
		int[] speeds = new int[] {};
		int[] answer;
		
		answer=solution(progresses,speeds);
		for(int i: answer) {
			System.out.println(i);
		}
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		
		Queue<node> queue = new LinkedList<node>();
		List<Integer> answerList = new ArrayList<>();
		
		int pLen = progresses.length;
		int count=0;
		int index =0;
		int j=0;
		if(pLen==0) {
			int[] answer = new int[1];
			return answer;
		}
		int[] answer = new int[100];
		
		for(int i=0; i<pLen; i++) {
			node value = new node(progresses[i],speeds[i]);
			System.out.println(value.progress);
			queue.add(value);
		}
		
		while(!queue.isEmpty()) {
			if(queue.peek().progress + ((queue.peek().speed)*j)>=100) {
				System.out.println(1);
				while(queue.peek().progress + ((queue.peek().speed)*j)>=100) {
					queue.remove();
					count++;
					if(queue.isEmpty()) {
						answer[index] = count;
						int[] re = new int[index+1];
						int a=0;
						for(int i: answer) {
							if(i!=0) {
								re[a] = i;
								a++;
							}else {
								a++;
							}
						}
						return re;
					}
				}
				answer[index] = count;
				index++;
				j++;
			}else {
				j++;
				count=0;
			}
		}
		
		return answer;
	}

}
