package 유형별문제.스택큐덱;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
public class 같은숫자는싫어 {

    public class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};
            LinkedList<Integer> list = new LinkedList<>();
            int prevIdx = 0;

            for(int item : arr) {
                if(list.isEmpty()) {
                    list.add(item);
                    continue;
                }

                if(list.get(prevIdx) == item) continue;

                list.add(item);
                prevIdx += 1;
            }

            // 외울것
//            return list.stream().mapToInt(Integer::intValue).toArray();
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
