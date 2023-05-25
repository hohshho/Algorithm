package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class num4485 {
    static int N, INF = Integer.MAX_VALUE;
    static int[][] map, dist;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Node> pq;
    static int caseNumber = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = stoi(br.readLine());

            if (N == 0) break;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");

                for (int j = 0; j < N; j++) {
                    map[i][j] = stoi(input[j]);
                }
            }

            dikjstra();
        }
        System.out.println(sb.toString());
    }

    static void dikjstra() {
        pq = new PriorityQueue<>();
        visited = new boolean[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            visited[cur.y][cur.x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];

                if (!checkMap(nx, ny)) continue;

                if (!visited[ny][nx] && dist[ny][nx] > dist[cur.y][cur.x] + map[ny][nx]) {
                    dist[ny][nx] = dist[cur.y][cur.x] + map[ny][nx];
                    pq.add(new Node(nx, ny, dist[ny][nx]));
                }
            }
        }

        sb.append("Problem " + caseNumber++ + ": " +dist[N - 1][N - 1] + "\n");
    }

    static public boolean checkMap(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node implements Comparable<Node> {
        int x, y, weight;

        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
