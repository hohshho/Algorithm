package 유형별문제.save;

public class zSolutionz3 {
    static class Solution {
        public int solution(int[] histogram) {
            int answer = 0;
            for(int i=0; i<histogram.length; i++){
                for(int j= i+1; j < histogram.length; j++){
                    int h = Math.min(histogram[i], histogram[j]);
                    int w = j - i - 1;

                    if(w < 1) continue;
                    answer = Math.max(answer, h * w);
                }
            }
            return answer;
        }
    }
}
