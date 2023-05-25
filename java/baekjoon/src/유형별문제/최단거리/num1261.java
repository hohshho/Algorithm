package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num1261 {
    static int N, M, INF = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] map, dist;
    static boolean[][] visited;
    static PriorityQueue<Point> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = stoi(input[0]); // 열
        M = stoi(input[1]); // 행
        map = new int[M][N];
        dist = new int[M][N];
        visited = new boolean[M][N];

        if(N == 1 && M == 1){
            System.out.println(map[0][0]);
            return;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
                dist[i][j] = INF;
            }
        }

        pq.add(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            visited[cur.y][cur.x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x, ny = dy[i] + cur.y;

                if (!checkPoint(nx, ny)) continue;

                if (visited[ny][nx]) continue;

                if (dist[ny][nx] <= cur.brokenWallCnt + map[ny][nx]) continue;

                dist[ny][nx] = cur.brokenWallCnt + map[ny][nx];
                visited[ny][nx] = true;
                pq.add(new Point(nx, ny, dist[ny][nx]));
            }
        }

        System.out.println(dist[M - 1][N - 1]);
    }

    static boolean checkPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Point implements Comparable<Point> {
        int brokenWallCnt, x, y;

        Point(int x, int y, int brokenWallCnt) {
            this.x = x;
            this.y = y;
            this.brokenWallCnt = brokenWallCnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.brokenWallCnt - o.brokenWallCnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
