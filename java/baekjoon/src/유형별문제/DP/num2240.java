package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] TW = br.readLine().split(" ");

        int T = stoi(TW[0]);
        int W = stoi(TW[1]);

        // [이동횟수][시간]
        int[][] dp = new int[W + 1][T + 1];

        for (int i = 1; i <= T; i++) {
            // 1번 나무, 2번 나무
            int cur = stoi(br.readLine());

            //  않고 자리에 그대로 있는 경우 처리
            if (cur == 1){
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }

            // 움직인 횟수에 대한 받은 자두 값 갱신
            for (int j = 1; j <= W; j++) {
                // 나무 1
                if (j % 2 == 0) {
                    if (cur == 1) {
                        dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j][i - 1] + 1);
                    } else {
                        dp[j][i] = Math.max(dp[j - 1][i - 1] + 1, dp[j][i - 1]);
                    }

                }
                // 나무 2
                else {
                    if (cur == 1) {
                        dp[j][i] = Math.max(dp[j - 1][i - 1] + 1, dp[j][i - 1]);
                    } else {
                        dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j][i - 1] + 1);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= W; i++)
            ans = Math.max(ans, dp[i][T]);

        System.out.println(ans);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
