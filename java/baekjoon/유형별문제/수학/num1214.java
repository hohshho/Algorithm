package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class num1214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int D = stoi(input[0]);
        int P = stoi(input[1]);
        int Q = stoi(input[2]);

        if (Q > P) {
            int tmp = Q;
            Q = P;
            P = tmp;
        }

        if (P == 1 || Q == 2 && D % 2 == 0 || D % P == 0 || D % Q == 0) {
            System.out.println(D);
            return;
        }

        int limit = D / P + 1;
        int answer = P - 1;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i <= limit; i++) {
            int remain = D - P * i;
            if (remain > 0 && remain % Q == 0) {
                System.out.println(D);
                return;
            }
            if (remain < 0) remain += Q;
            int tmp = Q - remain % Q;

            if (hs.contains(tmp)) break;
            hs.add(tmp);
            if (answer > tmp)
                answer = tmp;
        }
        System.out.println(D + answer);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
