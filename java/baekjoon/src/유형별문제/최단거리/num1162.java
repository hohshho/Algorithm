package 유형별문제.최단거리;

import java.io.*;
import java.util.*;


public class num1162 {
    static int N, M, K;
    static long LNF = Long.MAX_VALUE;
    static long res = LNF;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static long[][] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMK = br.readLine().split(" ");

        N = stoi(NMK[0]);
        M = stoi(NMK[1]);
        K = stoi(NMK[2]);

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Edge>());
        }

        dist = new long[N][K + 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], LNF);
        }

        for (int i = 0; i < M; i++) {
            String[] roadInput = br.readLine().split(" ");
            int start = stoi(roadInput[0]) - 1;
            int end = stoi(roadInput[1]) - 1;
            int weight = stoi(roadInput[2]);

            adj.get(start).add(new Edge(end, weight, 0));
            adj.get(end).add(new Edge(start, weight, 0));
        }

        dijkstra();

        for (long weight : dist[N - 1]) {
            res = Math.min(weight, res);
        }

        System.out.println(res);

    }

    public static void dijkstra() {

        pq.add(new Edge(0, 0, 0));
        for (int i = 0; i <= K; i++) {
            dist[0][i] = 0;
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.weight > dist[cur.e][cur.wrap]) continue;

            for (Edge next : adj.get(cur.e)) {
                long nextWeight = next.weight + cur.weight;

                if(nextWeight < dist[next.e][cur.wrap]) {
                    dist[next.e][cur.wrap] = nextWeight;
                    pq.add(new Edge(next.e, nextWeight, cur.wrap));
                }

                if(cur.wrap < K && cur.weight < dist[next.e][cur.wrap + 1]) {
                    dist[next.e][cur.wrap + 1] = cur.weight;
                    pq.add(new Edge(next.e, cur.weight, cur.wrap + 1));
                }
            }

        }

    }

    static class Edge implements Comparable<Edge> {
        int e, wrap;
        long weight;

        Edge(int e, long weight, int wrap) {
            this.e = e;
            this.weight = weight;
            this.wrap = wrap;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
