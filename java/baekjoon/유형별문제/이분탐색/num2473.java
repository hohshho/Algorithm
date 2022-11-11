package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class num2473 {
    static int N;
    static long[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        list = new long[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            list[i] = stol(input[i]);
        }

        Arrays.sort(list);

        int minIdx = 0, maxIdx = 0, midIdx = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = list[i] + list[left] + list[right];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    minIdx = i;
                    midIdx = left;
                    maxIdx = right;
                }

                if (sum >= 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(list[minIdx] + " " + list[midIdx] + " " + list[maxIdx]);

    }

    public static long stol(String s) {
        return Long.parseLong(s);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
