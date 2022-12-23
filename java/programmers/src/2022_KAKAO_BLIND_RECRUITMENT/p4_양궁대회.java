import java.util.ArrayList;
import java.util.Collections;

public class p4_양궁대회 {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int n = 5;
//        int[] info = new int[]{2,1,1,1,0,0,0,0,0,0,0};
        int n = 9;
        int[] info = new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        for (int item : sol.solution(n, info)) {
            System.out.println(item);
        }
    }

    // TODO: min Index랑 count 전처리 해서 굳이 answer 다시 정렬 안하게 짜보자
    static class Solution {
        static int[] answer = new int[11];
        static int[] ryan;
        static int[] apeach;
        static int N, minIdx, minCount;
        static int max = Integer.MIN_VALUE;

        public static void reCombination(int start, int depth) {
            if (depth == N) {
                int apeachSum = 0;
                int ryanSum = 0;
                int ryanMinIdx = 0;
                int ryanMinCount = 0;
                for (int i = 0; i <= 10; i++) {
                    if (apeach[i] == 0 && ryan[i] == 0) continue;

                    if(ryan[i] != 0) {
                        ryanMinIdx = i;
                        ryanMinCount = ryan[i];
                    }

                    if (apeach[i] < ryan[i]) ryanSum += 10 - i;
                    else apeachSum += 10 - i;
                }
                if (ryanSum > apeachSum) {
                    int diff = ryanSum - apeachSum;
                    if (diff > max) {
                        max = diff;
                        int[] temp = new int[N];
                        answer = ryan.clone();

                        minIdx = ryanMinIdx;
                        minCount = ryanMinCount;
                    } else if (diff == max) {
                        if(minIdx < ryanMinIdx || (minIdx == ryanMinIdx && minCount < ryanMinCount)) {
                            max = diff;
                            int[] temp = new int[N];
                            answer = ryan.clone();

                            minIdx = ryanMinIdx;
                            minCount = ryanMinCount;
                        }
                    }
                }

                return;
            }

            for (int i = start; i < 11; i++) {
                ryan[i]++;
                reCombination(i, depth + 1);
                ryan[i]--;
            }
        }

        public static int[] solution(int n, int[] info) {
            ryan = new int[11];
            N = n;
            apeach = info.clone();
            reCombination(0, 0);

            return max == Integer.MAX_VALUE ? new int[]{-1} : answer;
        }

//    public static void main(String[] args) {
//        System.out.println(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
//    }
    }

}
