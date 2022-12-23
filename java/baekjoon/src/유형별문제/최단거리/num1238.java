package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class num1238 {
    static int N, M, X, res = 0, INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMX = br.readLine().split(" ");

        N = stoi(NMX[0]);
        M = stoi(NMX[1]);
        X = stoi(NMX[2]) - 1; // index값

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            int start = stoi(input[0]) - 1;
            int end = stoi(input[1]) - 1;
            int weight = stoi(input[2]);

            adj.get(start).add(new Edge(end, weight));
        }

        for(int i=0; i<N; i++){
            if(i==X) continue;
            res = Math.max(dijkstra(i, X) + dijkstra(X, i), res);
        }

        System.out.println(res);
    }

    public static int dijkstra(int start, int end){
        init();

        q.add(new Edge(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Edge cur = q.poll();

            if(!visited[cur.e]) {
                visited[cur.e] = true;
                for(Edge next : adj.get(cur.e)) {
                    if(!visited[next.e] && dist[next.e] >= dist[cur.e] + next.weight) {
                        dist[next.e] = dist[cur.e] + next.weight;
                        q.add(new Edge(next.e, dist[next.e]));
                    }
                }
            }
        }

        return dist[end];
    }

    public static void init() {
        q = new PriorityQueue<>();
        visited = new boolean[N];
        dist = new int[N];

        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
    }

    static class Edge implements Comparable<Edge> {
        int e, weight;

        Edge(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
