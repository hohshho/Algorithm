package 유형별문제.DP.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num12015_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = stoi(st.nextToken());
        }

        int len = 0;
        dp[0] = list[0];
        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (list[i] > dp[len]) {
                len += 1;
                dp[len] = list[i];
            } else {
                idx = binarySearch(0, len, list[i], dp);
                dp[idx] = list[i];
            }
        }

        System.out.println(len + 1);

    }

    public static int binarySearch(int left, int right, int key, int[] dp) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (dp[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
