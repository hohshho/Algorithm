package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num1854 {
    static int N, M, K;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static int[] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static PriorityQueue<Integer>[] distanceList = new PriorityQueue[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            distanceList[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int time = stoi(st.nextToken());

            adj.get(start).add(new Edge(end, time));
        }

        pq.add(new Edge(1, 0));
        distanceList[1].add(0);

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            for (Edge next : adj.get(cur.e)) {
                int nextWeight = next.weight + cur.weight;

                if (distanceList[next.e].size() < K || distanceList[next.e].peek() > nextWeight) {
                    if(distanceList[next.e].size() == K) distanceList[next.e].poll();

                    distanceList[next.e].add(nextWeight);
                    pq.add(new Edge(next.e, nextWeight));
                }
            }

        }

        for (int i = 1; i < N + 1; i++) {
            if (distanceList[i].size() < K) System.out.println(-1);
            else System.out.println(distanceList[i].peek());
        }
    }

    static class Edge implements Comparable<Edge> {
        int e, weight;

        Edge(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.e - o.e;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
