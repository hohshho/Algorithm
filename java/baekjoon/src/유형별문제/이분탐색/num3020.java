package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class num3020 {
    static int N, H;
    // key : 높이, value : 개수
    static int[] suk, jong;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        H = stoi(st.nextToken());
        suk = new int[N / 2];
        jong = new int[N / 2];

        for (int i = 0; i < N; i++) {
            int input = stoi(br.readLine());

            // 1. i % 2 == 1 -> 석순
            if (i % 2 == 1) {
                suk[i / 2] = input;

            }
            // 2. i % 2 == 0 -> 종유석
            else {
                jong[i / 2] = input;
            }
        }

        Arrays.sort(suk);
        Arrays.sort(jong);

        int min = N;
        int cnt = 0;
        for (int i = 1; i < H + 1; i++) {
            int tempCnt = binarySearch(0, N / 2, i, jong) + binarySearch(0, N / 2, H - i - 1, suk);

            if (tempCnt == min) {
                cnt += 1;
                continue;
            }

            if (min > tempCnt) {
                min = tempCnt;
                cnt = 1;
            }
        }
        System.out.println(min + " " + cnt);
    }

    public static int binarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
