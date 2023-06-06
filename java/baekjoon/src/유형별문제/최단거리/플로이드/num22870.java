package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num22870 {
    static int N, M, S, E, INF = Integer.MAX_VALUE, res;
    static int[] dist, prev;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int weight = stoi(st.nextToken());

            adj.get(start).add(new Edge(end, weight));
            adj.get(end).add(new Edge(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        S = stoi(st.nextToken());
        E = stoi(st.nextToken());

        dijkstra(S, E, true);
        dijkstra(S, E, false);

        System.out.println(res);
    }

    public static void dijkstra(int start, int end, boolean action) {
        dist = new int[N + 1];

        prev = new int[N + 1];

        visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            visited[cur.e] = true;

            for (Edge next : adj.get(cur.e)) {
                if (visited[next.e]) continue;

                if (dist[next.e] <= next.weight + dist[cur.e]) continue;

                if(!action ) {
                    continue;
                }

                dist[next.e] = next.weight + dist[cur.e];
                pq.add(new Edge(next.e, dist[next.e]));
                prev[next.e] = cur.e;
            }
        }

        res += dist[end];
    }

    public static class Edge implements Comparable<Edge> {
        int e, weight;

        Edge(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
