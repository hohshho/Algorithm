package 유형별문제.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num6987 {
    static int[] res = new int[4];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            // 승 = 패, 무는 짝수, 총합은 30개)
            String[] input = br.readLine().split(" ");
            int sum = 30, win = 0, lose = 0, tie = 0;

            for (int j = 0; j < 6; j++) {

                for (int k = 0; k < 3; k++) {
                    int idx = 3 * j + k;
                    int value = stoi(input[idx]);

                    if (idx % 3 == 0) {
                        win += value;
                    }
                    if (idx % 3 == 1) {
                        tie += value;
                    }
                    if (idx % 3 == 2) {
                        lose += value;
                    }
                }
            }

        }

        for (int i = 0; i < 4; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
