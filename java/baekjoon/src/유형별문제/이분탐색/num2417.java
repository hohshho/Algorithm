package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2417 {
    static long n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = stol(br.readLine());

        bsearch();

        System.out.println(result);
    }

    static void bsearch() {
        long start = 0;
        long end = n;
        long mid, checkValue;

        while (start <= end) {
            mid = (start + end) / 2;
            checkValue = (long) Math.pow(mid, 2);

            if (checkValue >= n) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

    }

    static long stol(String s) {
        return Long.parseLong(s);
    }
}
