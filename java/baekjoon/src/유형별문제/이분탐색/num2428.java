package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class num2428 {
    static int N;
    static long result = 0;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());

        String[] input = br.readLine().split(" ");
        list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = stoi(input[i]);
        }

        Arrays.sort(list);

        for (int i = 1; i < N; i++) {
            bsearch(i);
        }

        System.out.println(result);

    }

    public static void bsearch(int i) {
        int s = 0, mid = 0, e = i - 1;

        while (s <= e) {
            mid = (s + e) / 2;
            if (list[mid] * 10 < list[i] * 9) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        result += i - s;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static long stol(String s) {
        return Long.parseLong(s);
    }
}
