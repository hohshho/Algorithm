package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num1956 {
    static int V, E, INF = 987654321, res = INF;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;
            int weight = stoi(st.nextToken());

            dist[start][end] = weight;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    continue;
                }

                // 자기 자신을 제외한 두 정점이 경로가 있으면 사이클 존재
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    res = Math.min(res, dist[i][j] + dist[j][i]);
                }
            }
        }

        // ans가 초기값이면 사이클이 존재하지 않음.
        res = (res == INF) ? -1 : res;

        System.out.println(res == INF ? -1 : res);
    }

    public static class Node {
        int e, weight;

        Node(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
