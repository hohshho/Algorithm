package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num11048 {
    static int N, M;
    static int[][] map, dist;
    static int[] dx = {-1, 0, -1}, dy = {0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        dist[0][0] = map[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int x = j, y = i;
                int max = map[y][x];

                for (int k = 0; k < 3; k++) {
                    int px = x + dx[k], py = y + dy[k];
                    if (!checkValue(px, py)) continue;

                    max = Math.max(max, map[y][x] + dist[py][px]);
                }
                dist[y][x] = max;
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }

    public static boolean checkValue(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
