package pccp;
import java.util.*;

public class 신입사원교육 {


    class Solution {
        public int solution(int[] abilitys, int number) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int ability : abilitys) {
                pq.add(ability);
                answer += ability;
            }
            while(number-- > 0) {
                int first = pq.poll();
                int second = pq.poll();

                answer -= first + second;
                pq.add(first + second);
                pq.add(first + second);
                answer += 2 * (first + second);
            }

            return answer;
        }
    }
}
