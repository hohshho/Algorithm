package 유형별문제.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11501 {
    static int T, N;
    static int[] list;
    static long[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());
        res = new long[T];

        for (int i = 0; i < T; i++) {
            N = stoi(br.readLine());
            String[] input = br.readLine().split(" ");

            list = new int[N];
            int max = 0;

            for (int j = 0; j < N; j++) {
                list[j] = stoi(input[j]);
            }

            for (int j = 1; j <= N; j++) {
                if (list[N - j] > max) {
                    max = list[N - j];
                } else {
                    res[i] += (max - list[N - j]);
                }
            }
        }

        for (long item : res) {
            System.out.println(item);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
