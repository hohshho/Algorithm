package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num17141 {
    static int N, M, virusCnt, INF = Integer.MAX_VALUE, res = INF;
    static int[][] initMap;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        initMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                initMap[i][j] = stoi(st.nextToken());
            }
        }


    }

    public static void combination(int idx, int cnt, int[] selected) {


    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
