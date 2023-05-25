package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num14938 {
    static int N, M, R, res = 0, INF = Integer.MAX_VALUE;
    static int[] items;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        R = stoi(st.nextToken());

        items = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            items[i] = stoi(st.nextToken());
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;
            int weight = stoi(st.nextToken());

            adj.get(start).add(new Edge(end, weight));
            adj.get(end).add(new Edge(start, weight));
        }

        for (int i = 0; i < N; i++) {
            pq = new PriorityQueue<Edge>();
            pq.add(new Edge(i, 0));
            int[] dist = new int[N];
            boolean[] visited = new boolean[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(visited, false);
            dist[i] = 0;

            while (!pq.isEmpty()) {
                Edge cur = pq.poll();
                visited[cur.e] = true;

                for (Edge next : adj.get(cur.e)) {
                    int nextWeight = cur.weight + next.weight;

                    if(visited[next.e]) continue;

                    if(dist[next.e] < nextWeight) continue;

                    pq.add(new Edge(next.e, nextWeight));
                    dist[next.e] = nextWeight;
                }
            }

            int point = 0;

            for (int j = 0; j < N; j++) {
                if (dist[j] <= M) {
                    point += items[j];
                }
            }

            res = Math.max(res, point);
        }

        System.out.println(res);

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
