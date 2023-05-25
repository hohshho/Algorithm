package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num20183 {
    static int N, M, A, B;
    static Long C;
    static ArrayList<ArrayList<Point>> adj = new ArrayList<ArrayList<Point>>();
    static Point res;
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static long[] dist;
    static boolean[] visited;
    static long LNF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stol(st.nextToken());

        dist = new long[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            dist[i] = LNF;
            visited[i] = false;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            Long weight = Long.parseLong(st.nextToken());

            adj.get(start).add(new Point(end, weight, weight));
            adj.get(end).add(new Point(start, weight, weight));
        }

        pq.add(new Point(A, 0, 0));
        dist[A] = 0;

        while (true) {
            boolean resIndex = false;

            while (!pq.isEmpty()) {
                Point cur = pq.poll();
                visited[cur.e] = true;

                for (Point next : adj.get(cur.e)) {
                    if (visited[next.e]) continue;

                    if (dist[next.e] < dist[cur.e] + next.weight) continue;

                    dist[next.e] = dist[cur.e] + next.weight;
                    pq.add(new Point(next.e, dist[next.e], Math.max(next.max, cur.max)));
                    visited[next.e] = true;

                    if (next.e == B) {
                        res = new Point(cur.e, next.e, dist[next.e], Math.max(next.max, cur.max));
                        resIndex = true;
                    }
                }
            }

            if (!resIndex) {
                System.out.println(-1);
                return;
            }

            if (res.weight <= C) {
                System.out.println(res.max);
                return;
            }

            resIndex = false;
            pq = new PriorityQueue<>();
            Arrays.fill(dist, LNF);
            Arrays.fill(visited, false);
            pq.add(new Point(A, 0, 0));
            dist[A] = 0;

            ArrayList<Point> list = adj.get(res.s);
            for (int i = 0; i < list.size(); i++) {
                Point cur = list.get(i);
                if (cur.e == res.e) {
                    adj.get(res.s).remove(i);
                }
            }

            list = adj.get(res.e);
            for (int i = 0; i < list.size(); i++) {
                Point cur = list.get(i);
                if (cur.e == res.s) {
                    adj.get(res.e).remove(i);
                }
            }
        }


    }

    static class Point implements Comparable<Point> {
        int s, e;
        long max, weight;

        Point(int s, int e, long weight, long max) {
            this.s = s;
            this.e = e;
            this.weight = weight;
            this.max = max;
        }

        Point(int e, long weight, long max) {
            this.e = e;
            this.weight = weight;
            this.max = max;
        }

        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight > 0 ? 1 : 0;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static long stol(String s){
        return Long.parseLong(s);
    }
}
