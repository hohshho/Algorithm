package kit;

import java.util.*;

public class dp_정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
//        dp[1][0] = dp[0][0] + triangle[1][0];  dp[2][0] = dp[1][0] + triangle[2][0];
//        dp[1][1] = dp[0][0] + triangle[1][1];  dp[2][2] = do[1][1] + triangle[2][2];
        for (int i = 0; i < triangle.length - 1; i++) { // i : 현재 높이 - 1
            int pre = i;
            int cur = i + 1;
            for (int j = 0; j <= i + 1; j++) {
                // 현재 높이의 첫번재 노드, 마지막 노드 예외 처리
                if(j == 0 || j == i + 1) {
                    dp[cur][j] = dp[i][j == 0 ? 0 : i] + triangle[cur][j];
                    continue;
                }

                // dp 갱신
                dp[cur][j] = triangle[cur][j] + Math.max(dp[pre][j - 1], dp[pre][j]);

                // 마지막 층일 경우 max값 갱신
                if(i == triangle.length - 2) {
                    answer = Math.max(answer, dp[cur][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        dp_정수삼각형 sol = new dp_정수삼각형();

        int item = sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});

        System.out.println(item);
    }
}

