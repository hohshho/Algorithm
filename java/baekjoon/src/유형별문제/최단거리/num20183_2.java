package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num20183_2 {
    static int N, M, A, B;
    static Long C;
    static ArrayList<ArrayList<Point>> adj = new ArrayList<ArrayList<Point>>();
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static long[] maxList;
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

        maxList = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            maxList[i] = LNF;
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
        maxList[A] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if(cur.max >= maxList[cur.e]) continue;

            if(cur.e == B) {
                System.out.println(cur.max);
                return;
            }

            maxList[cur.e] = cur.max;

            for (Point next : adj.get(cur.e)) {
                long nextSum = cur.weight + next.weight;

                if (maxList[next.e] < Math.max(next.max, cur.max)) continue;

                if (C < nextSum) continue;

                pq.add(new Point(next.e, nextSum, Math.max(next.max, cur.max)));
            }
        }
        System.out.println(-1);


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
            if(this.max > o.max) return 1;
            if(this.max < o.max) return -1;
            if(this.max == o.max){
                if(this.weight > o.weight) return 1;
                if(this.weight < o.weight) return -1;
            }
            return 0;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static long stol(String s) {
        return Long.parseLong(s);
    }
}
