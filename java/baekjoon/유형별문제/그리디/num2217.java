package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = stoi(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = stoi(br.readLine());
        }

        Arrays.sort(rope);

        int result = 0, index;

        for (int i = 0; i < N; i++) {
            result = Math.max(result, rope[i] * (N - i));
        }

        System.out.println(result);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
