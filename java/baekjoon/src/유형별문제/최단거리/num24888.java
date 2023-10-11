package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num24888 {
    static int N, M, INF = 987654321;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    static int[] dist, distMaxCnt;
    static int[] passwordPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        dist = new int[N];
        distMaxCnt = new int[N];
        passwordPoint = new int[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;
            int weight = stoi(st.nextToken());

            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            passwordPoint[i] = stoi(st.nextToken());
        }

        dijkstra();

//        TODO:

    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.e] = true;

            for(Node next : adj.get(cur.e)) {
                int nextWeight = cur.w + next.w;
                if(visited[next.e]) continue;

                if(dist[next.e] < nextWeight) continue;

                pq.add(new Node(next.e, nextWeight));
                dist[next.e] = nextWeight;
            }

        }
    }

    public static class Node implements Comparable<Node>{
        int e, w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
