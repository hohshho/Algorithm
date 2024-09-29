package 유형별문제.완전탐색;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java
public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            // 총 카펫의 넓이
            int sum = brown + yellow;

            // 가로 3이상
            for (int i = 3; i < sum; i++) {
                int sero = i;
                int garo = sum / sero;

                if ((garo - 2) * (sero - 2) == yellow) {
                    answer[0] = garo;
                    answer[1] = sero;
                    break;
                }
            }
            return answer;
        }
    }
}
