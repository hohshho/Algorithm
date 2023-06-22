package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num10473 {
    static Point start, end;
    static int n, edgeCnt;
    static ArrayList<Point> list = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Point(stof(st.nextToken()), stof(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        end = new Point(stof(st.nextToken()), stof(st.nextToken()));

        n = stoi(br.readLine());
        edgeCnt = n + 2;

        list.add(new Point(start.x, start.y));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new Point(stof(st.nextToken()), stof(st.nextToken())));
        }

        list.add(new Point(end.x, end.y));

        for (int i = 0; i < edgeCnt; i++) {
            adj.add(new ArrayList<>());
        }

        // 도착 지점 간 시간 처리
        // 출발지 처리
        for (int i = 1; i < edgeCnt; i++) {
            Point end = list.get(i);
            adj.get(0).add(new Edge(i, getTime(getDistance(start.x, start.y, end.x, end.y))));
        }

        // 대포, 도착지 처리
        for (int i = 1; i < edgeCnt; i++) {
            for (int j = 1; j < edgeCnt; j++) {
                Point p1 = list.get(i);
                Point p2 = list.get(j);

                if (i == j) continue;

                float distance = getDistance(p1.x, p1.y, p2.x, p2.y);
                adj.get(i).add(
                        new Edge(j, (float) Math.min(getTime(distance), Math.abs(getTime(distance - 50)) + 2.0)));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        float[] times = new float[edgeCnt];
        Arrays.fill(times, Integer.MAX_VALUE);
        boolean[] visited = new boolean[edgeCnt];

        times[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.destination]) continue;
            visited[cur.destination] = true;

            for (Edge next : adj.get(cur.destination)) {
                if(times[next.destination] < times[cur.destination] + next.time) continue;

                times[next.destination] = times[cur.destination] + next.time;
                pq.add(new Edge(next.destination, times[next.destination]));
            }
        }

        System.out.println(times[edgeCnt - 1]);
    }

    public static float getDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static float getTime(float distance) {
        return (float) (distance / 5.0);
    }

    public static class Edge implements Comparable<Edge> {
        int destination;
        float time;

        public Edge(int destination, float time) {
            this.destination = destination;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return Float.compare(this.time, o.time);
        }

    }

    public static class Point {
        float x, y;

        Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static float stof(String s) {
        return Float.parseFloat(s);
    }
}
