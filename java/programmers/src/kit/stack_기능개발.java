package kit;

import java.util.*;

class stack_기능개발 {
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

        for(int i=0; i<pLen; i++) {
            node value = new node(progresses[i],speeds[i]);
            System.out.println(value.progress);
            queue.add(value);
        }

        while(!queue.isEmpty()) {
            if(queue.peek().progress + ((queue.peek().speed)*j)>=100) {
                while(queue.peek().progress + ((queue.peek().speed)*j)>=100) {
                    queue.remove();
                    count++;
                    if(queue.isEmpty()) {
                        break;
                    }
                }
                answerList.add(count);
                j++;
            }else {
                j++;
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