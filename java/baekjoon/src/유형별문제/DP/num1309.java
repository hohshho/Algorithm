package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] list = new int[3][N + 1];

        list[0][1] = list[1][1] = list[2][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) list[j][i] = (list[1][i - 1] + list[2][i - 1] + list[0][i - 1]) % 9901;
                else if (j == 1) list[j][i] = (list[2][i - 1] + list[0][i - 1]) % 9901;
                else list[j][i] = (list[1][i - 1] + list[0][i - 1]) % 9901;
            }
        }

        int res = 0;
        for (int i = 0; i < 3; i++) {
            res += list[i][N];
        }

        System.out.println(res % 9901);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
