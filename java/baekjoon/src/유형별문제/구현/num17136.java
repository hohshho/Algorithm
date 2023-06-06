package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num17136 {
    static int res = -1, ㅇㄴㅁ;
    static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        // 개수 dfs

        // 위치 dfs

        System.out.println(res);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
