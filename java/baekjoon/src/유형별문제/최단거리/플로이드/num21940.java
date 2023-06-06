package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class num21940 {
    static int N, M, K, INF = 987654321;
    static int[] C;
    static int[][] dist;
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = i == j ? 0 : INF;
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;
            int weight = stoi(st.nextToken());

            dist[start][end] = weight;
        }

        K = stoi(br.readLine());
        C = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            C[i] = stoi(st.nextToken()) - 1;
        }

        // TODO:
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int MIN = INF;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            boolean pass = false;
            for (int person : C) {
                if (dist[i][person] == INF || dist[person][i] == INF) {
                    pass = true;
                    break;
                }
                sum = Math.max(sum, dist[i][person] + dist[person][i]);
            }

            if (pass) continue;

            if (MIN < sum) continue;

            if (MIN > sum) {
                    res = new ArrayList<>();
                    MIN = sum;
            };

            res.add(i);
        }

        for (int item : res) {
            System.out.print((item + 1) + " ");
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
