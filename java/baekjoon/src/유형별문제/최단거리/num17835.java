package 유형별문제.최단거리;

import java.io.*;
import java.util.*;

public class num17835 {
    static int N, M, K, res;
    static long LNF = Long.MAX_VALUE, resDistance;
    static long[] dist;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static HashSet<Integer> interviewRooms = new HashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Edge>());
        }

        dist = new long[N + 1];
        Arrays.fill(dist, LNF);

        // 면접장으로 부터 먼거리 찾기위해 순서 변경
        for (int i = 0; i < M; i++) {
            String[] roadData = br.readLine().split(" ");
            int start = stoi(roadData[0]);
            int end = stoi(roadData[1]);
            int weight = stoi(roadData[2]);

            adj.get(end).add(new Edge(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int interview = stoi(st.nextToken());
            interviewRooms.add(interview);
            pq.add(new Edge(interview, 0));
            dist[interview] = 0;
        }

        dijkstra();

        for (int i = 1; i <= N; i++) {
            if (resDistance < dist[i]) {
                resDistance = dist[i];
                res = i;
            }
        }
        System.out.println(res);
        System.out.println(resDistance);
    }

    public static void dijkstra() {
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.e] < cur.weight) continue;

            ArrayList<Edge> cities = adj.get(cur.e);
            for (Edge city : cities) {
                if (dist[city.e] > city.weight + cur.weight) {
                    dist[city.e] = city.weight + cur.weight;
                    pq.add(new Edge(city.e, dist[city.e]));
                }
            }

        }
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
