package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num7579 {
    static int N, K, S, INF = 1000000000;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            dist[start][end] = 1;
        }

        for (int k = 0; k <= N; k++) {
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        S = stoi(br.readLine());

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            if(dist[start][end] == 1) {
                System.out.println(-1);
            }
            else if(dist[end][start] == 1) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
