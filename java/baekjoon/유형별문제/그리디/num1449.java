package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num1449 {
    static int N, L, holes[], cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NL = br.readLine().split(" ");

        N = stoi(NL[0]);
        L = stoi(NL[1]);
        holes = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            holes[i] = stoi(input[i]);
        }
        Arrays.sort(holes);

        int pre = holes[0];
        double size = 0.5;
        for (int i = 1; i < holes.length; i++) {
            double diff = holes[i] - pre;
            pre = holes[i];

            if (size + diff < L) {
                size += diff;
                continue;
            }

            size = 0.5;
            cnt++;
        }

        System.out.println(cnt);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
