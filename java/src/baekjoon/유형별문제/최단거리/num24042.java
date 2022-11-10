package MinPath;

import java.util.*;
import java.io.*;

public class num24042 {
    static int N, M, start, end, weight;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static long[] dist;
    static long res, INF = Long.MAX_VALUE;
    static boolean[] visited;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] se = br.readLine().split(" ");

            start = stoi(se[0]) - 1;
            end = stoi(se[1]) - 1;
            weight = i;

            adj.get(start).add(new Edge(end, weight));
            adj.get(end).add(new Edge(start, weight));
        }

        dijkstra(0, N - 1);

        System.out.println(res);
    }

    public static void dijkstra(int start, int end) {
        init();

        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.cost > dist[cur.node]) continue;

            for (Edge next : adj.get(cur.node)) {
                long nextCost = cur.cost + next.w + 1 - (cur.cost % M);

                if(cur.cost % M > next.w)
                    nextCost += M;

                if (dist[next.e] > nextCost) {
                    dist[next.e] = nextCost;
                    q.add(new Node(next.e, nextCost));
                }
            }
        }

        res = dist[end];
    }

    public static void init() {
        q = new PriorityQueue<>();
        dist = new long[N];

        Arrays.fill(dist, INF);
    }

    static class Edge{
        int e, w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node>{
        int node;
        long cost;
        Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return (int) (cost - o.cost);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
