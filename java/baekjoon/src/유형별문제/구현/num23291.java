package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num23291 {
    static int N, K, INF = Integer.MAX_VALUE, res = 0, bottomY, max, min;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        // 어항 (배열) -> 어항은 최대 높이가 N / 2
        map = new int[N / 2][N];
        bottomY = N / 2 - 1;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[bottomY][i] = stoi(st.nextToken());
        }

        // 정리
        while (max - min <= K) {
            run();
            res += 1;
        }

        System.out.println(res);
    }

    public static void run() {
        // startCnt : 처음 공중 부양 시 올릴 개수
        for (int startCnt = 1; startCnt <= N / 2; startCnt *= 2) {
            int bottomCnt = N;


        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
