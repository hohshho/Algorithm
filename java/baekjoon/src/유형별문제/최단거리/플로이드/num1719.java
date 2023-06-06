package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1719 {
    static int N, M, INF = 987654321;
    static int[][] dist;
    static int[][] pre;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        dist = new int[N][N];
        pre = new int[N][N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
            for(int j=0; j<N; j++){
                dist[i][j] = INF;
                pre[i][j] = j;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;
            int weight = stoi(st.nextToken());

            dist[start][end] = weight;
            dist[end][start] = weight;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pre[i][j] = pre[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) System.out.print("-" + " ");
                else System.out.print(pre[i][j] + 1 + " ");
            }
            System.out.println();
        }
    }

    public static int find(int start, int end){
        if(pre[start][end] != start) {
//            find()
            return 0;
        }
        return pre[start][end];

    }

    static class Edge {
        int e, weight;

        Edge(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
