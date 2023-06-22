package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num12913 {
    static int N, K;
    static boolean[][] visited;
    static double[][] minTimes;
    static double res = Double.MAX_VALUE;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] items = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                int item = stoi(items[j]);

                if (i == j) continue;

                adj.get(i).add(new Node(j, 0, item));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[K + 1][N];
        minTimes = new double[K + 1][N];

        for (int i = 0; i <= K; i++) {
            Arrays.fill(minTimes[i], Double.MAX_VALUE);
            minTimes[i][0] = 0;
        }

        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.k][cur.e]) continue;
            visited[cur.k][cur.e] = true;

            for (Node next : adj.get(cur.e)) {
                // 알약 사용 안함
                if (minTimes[cur.k][next.e] > minTimes[cur.k][cur.e] + next.time) {
                    minTimes[cur.k][next.e] = minTimes[cur.k][cur.e] + next.time;
                    pq.add(new Node(next.e, cur.k, minTimes[cur.k][next.e]));
                }

                int nextK = cur.k + 1;
                if (nextK > K) continue;

                // 알약 사용
                if (minTimes[nextK][next.e] > minTimes[cur.k][cur.e] + (next.time / 2)) {
                    minTimes[nextK][next.e] = minTimes[cur.k][cur.e] + (next.time / 2);
                    pq.add(new Node(next.e, nextK, minTimes[nextK][next.e]));
                }
            }
        }

        for (int i = 0; i <= K; i++) {
            res = Math.min(res, minTimes[i][1]);
        }

        System.out.println(res);
    }

    public static class Node implements Comparable<Node> {
        int e, k;
        double time;

        public Node(int e, int k, double time) {
            this.e = e;
            this.k = k;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.time - o.time);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
