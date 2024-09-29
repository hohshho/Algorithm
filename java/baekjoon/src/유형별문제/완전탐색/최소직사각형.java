package 유형별문제.완전탐색;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java
public class 최소직사각형 {

    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int sero = 0;
            int garo = 0;

            // 명함 가로로 길게, 세로는 짧게
            for(int[] paper : sizes) {
                int tempSero = Math.min(paper[0], paper[1]);
                int tempGaro = Math.max(paper[0], paper[1]);

                sero = Math.max(sero, tempSero);
                garo = Math.max(garo, tempGaro);
            }

            return sero * garo;
        }
    }
}
