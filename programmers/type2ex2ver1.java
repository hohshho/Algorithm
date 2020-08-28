package programmers;

import java.util.*;

public class type2ex2ver1 {
	public static void main(String[] args) {
		int[] progresses = new int[] {99, 1};
		int[] speeds = new int[] {1, 99};
		int[] answera;
		
		answera=solution(progresses,speeds);
		for(int i: answera) {
			System.out.println(i);
		}
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		
		Queue<node> queue = new LinkedList<node>();
		List<Integer> answerList = new ArrayList<>();
		
		int pLen = progresses.length;
		int count=0;
		int day=0;
		if(pLen==0) {
			int[] answer = new int[1];
			return answer;
		}
		
		for(int i=0; i<pLen; i++) {
			node value = new node(progresses[i],speeds[i]);
			queue.add(value);
		}
		
		while(!queue.isEmpty()) {
			if(queue.peek().progress + ((queue.peek().speed)*day)>=100) {
				while(queue.peek().progress + ((queue.peek().speed)*day)>=100) {
					queue.remove();
					count++;
					if(queue.isEmpty()) {
						break;
					}
				}
				answerList.add(count);
				day++;
			}else {
				day++;	
				count=0;
			}
		}
		
        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
	}

}

class node{
	int progress;
	int speed;
	node(int progress, int speed){
		this.progress=progress;
		this.speed=speed;
	}
}
