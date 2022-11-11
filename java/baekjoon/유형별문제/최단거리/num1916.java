package MinPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class num1916 {
    static int N, M, start, end, weight, INF = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        M = stoi(br.readLine());

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            start = stoi(input[0]) - 1;
            end = stoi(input[1]) - 1;
            weight = stoi(input[2]);
            adj.get(start).add(new Edge(end, weight));
        }
        
        String[] SE = br.readLine().split(" ");
        start = stoi(SE[0]) -1;
        end = stoi(SE[1]) -1;

        System.out.println(dijkstra(start, end));

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
                    if(!visited[next.e] && dist[next.e] >= dist[cur.e] + next.w) {
                        dist[next.e] = dist[cur.e] + next.w;
                        q.add(new Edge(next.e, dist[next.e]));
                    }
                }
            }
        }

        return dist[end];
    }

    public static void init(){
        q = new PriorityQueue<>();
        dist = new int[N];
        visited = new boolean[N];
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
    }

    static class Edge implements Comparable<Edge> {
        int e, w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
