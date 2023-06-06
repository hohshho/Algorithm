package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num17182 {
    static int N, K, res = Integer.MAX_VALUE;
    static int[][] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dist = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = stoi(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        visited[K] = true;
        permutation(K, 1, 0);

        System.out.println(res);
    }

    public static void permutation(int cur, int cnt, int weight) {
        if (cnt == N) {
            res = Math.min(weight, res);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            permutation(i, cnt + 1, weight + dist[cur][i]);
            visited[i] = false;
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
