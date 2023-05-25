package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num18223 {
    static int V, E, P, INF = 987654321;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        P = stoi(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int weight = stoi(st.nextToken());

            adj.get(start).add(new Edge(end, weight));
            adj.get(end).add(new Edge(start, weight));
        }

        int len1 = dijkstra(1, P) + dijkstra(P, V);
        int len2 = dijkstra(1, V);

        if (len1 == len2) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int dijkstra(int start, int end) {
        pq = new PriorityQueue<>();
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        Arrays.fill(dist, INF);

        pq.add(new Edge(start, 0));
        dist[start] = 0;
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.e]) continue;

            visited[cur.e] = true;

            if (cur.e == end) return dist[cur.e];

            for (Edge next : adj.get(cur.e)) {
                if (!visited[next.e] && dist[next.e] > dist[cur.e] + next.weight) {
                    dist[next.e] = dist[cur.e] + next.weight;
                    pq.add(new Edge(next.e, next.weight));
                }
            }
        }
        return dist[end];
    }

    static class Edge implements Comparable<Edge> {
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
