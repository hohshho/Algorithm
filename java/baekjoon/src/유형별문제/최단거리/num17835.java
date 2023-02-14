package 유형별문제.최단거리;

import java.io.*;
import java.util.*;

public class num17835 {
    static int N, M, K;
    static long LNF = Long.MAX_VALUE, res = 0, resLen = 0;
    static boolean[] visited;
    static long[] dist;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
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
        visited = new boolean[N];
        dist = new long[N];
        Arrays.fill(visited, false);
        Arrays.fill(dist, LNF);

        // 면접장으로 부터 먼거리 찾기위해 순서 변경
        for (int i = 0; i < M; i++) {
            String[] roadData = br.readLine().split(" ");
            int start = stoi(roadData[0]);
            int end = stoi(roadData[1]);
            int weight = stoi(roadData[2]);

            adj.get(end).add(new Edge(start, weight));
        }

        dijkstra();

        // TODO: + 1 해야함
        System.out.println();
        System.out.println(res);
    }

    public static void dijkstra() {



    }

    static class Edge implements Comparable<Edge> {
        int e;
        long weight;

        Edge(int e, long weight) {
            this.e = e;
            this.weight = weight;
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
