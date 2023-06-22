package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num10282 {
    // T : 테스트 수, idx : 진행중인 테스트, n : 컴퓨터 개수, d : 의존성 개수, c : 해킹 시작 컴퓨터
    static int T, idx, n, d, c, INF = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static ArrayList<Result> results = new ArrayList<>();
    static ArrayList<ArrayList<Node>> adj;
    static PriorityQueue<Node> pq;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());
        idx = 0;

        while (idx++ < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = stoi(st.nextToken());
            d = stoi(st.nextToken());
            c = stoi(st.nextToken());

            adj = new ArrayList<>();
            pq = new PriorityQueue<>();
            dist = new int[n];
            visited = new boolean[n];
            int curCnt = 0;
            int maxTime = 0;
            int maxIdx = 0;

            Arrays.fill(dist, INF);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int end = stoi(st.nextToken()) - 1;
                int start = stoi(st.nextToken()) - 1;
                int time = stoi(st.nextToken());

                adj.get(start).add(new Node(end, time));
            }

            pq.add(new Node(c - 1, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (!visited[cur.end]) curCnt += 1;
                visited[cur.end] = true;

                for (Node next : adj.get(cur.end)) {
                    int nextWeight = cur.time + next.time;

                    if (visited[next.end]) continue;

                    if (nextWeight > dist[next.end]) continue;

                    pq.add(new Node(next.end, nextWeight));
                    dist[next.end] = nextWeight;
                }
            }

            for (int item : dist) {
                if(item == INF) continue;

                maxTime = Math.max(maxTime, item);
            }

            results.add(new Result(curCnt, maxTime));
        }

        for (Result result : results) {
            System.out.println(result.cnt + " " + result.time);
        }
    }


    public static class Node implements Comparable<Node> {
        int end, time;

        Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static class Result {
        int cnt, time;

        Result(int cnt, int time) {
            this.cnt = cnt;
            this.time = time;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
