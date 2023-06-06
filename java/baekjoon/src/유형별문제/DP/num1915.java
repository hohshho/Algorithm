package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1915 {
    static int N, M, res = 0;
    static int[][] maps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // y
        M = stoi(st.nextToken()); // x

        maps = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("");

            // 가로 dp 생성
            for (int j = 1; j <= M; j++) {
                int cur = stoi(input[j-1]);

                if (cur == 0) continue;

                maps[i][j] = Math.min(maps[i-1][j-1], Math.min(maps[i-1][j], maps[i][j-1])) + 1;
                res = Math.max(res, maps[i][j]);
            }
        }

        System.out.println(res * res);
    }

    public static boolean checkMapArrange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
