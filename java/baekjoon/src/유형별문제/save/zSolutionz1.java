package 유형별문제.save;

public class zSolutionz1 {
    static class Solution {
        public long solution(long n) {
            long answer = 0;

            for(long i=1; i<n; i++){
                answer += (n + 1) * i;
            }

            return answer;
        }
    }
}
