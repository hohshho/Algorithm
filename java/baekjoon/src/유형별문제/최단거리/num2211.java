package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num2211 {
    static int N, M, cnt, INF = Integer.MAX_VALUE;
    static int[] dist, prev;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int time = stoi(st.nextToken());

            adj.get(start).add(new Node(end, time));
            adj.get(end).add(new Node(start, time));
        }

        dist = new int[N + 1];
        prev = new int[N + 1];
        visited = new boolean[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        Arrays.fill(prev, INF);
        Arrays.fill(visited, false);
        dist[1] = 0;
        prev[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.e]) continue;
            visited[cur.e] = true;

            for (Node next : adj.get(cur.e)) {
                if (dist[next.e] < dist[cur.e] + next.time) continue;

                dist[next.e] = dist[cur.e] + next.time;
                pq.add(new Node(next.e, dist[next.e]));
                prev[next.e] = cur.e;
            }
        }

        StringBuilder sb = new StringBuilder();

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (prev[i] == 0) continue;
            sb.append(prev[i] + " " + i + "\n");
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static class Node implements Comparable<Node> {
        int e, time;

        public Node(int e, int time) {
            this.e = e;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
