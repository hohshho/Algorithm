package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2212 {
    static int N, K, senses[], diff[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        K = stoi(br.readLine());

        senses = new int[N];
        diff = new int[N - 1];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            senses[i] = stoi(input[i]);
        }

        Arrays.sort(senses);

        int pre = senses[0];
        for (int i = 1; i < N; i++) {
            int cur = senses[i];
            diff[i - 1] = cur - pre;
            pre = cur;
        }

        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < diff.length - K + 1; i++){
            sum += diff[i];
        }

        System.out.println(sum);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
