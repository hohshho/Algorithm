package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num14442 {
    static int N, M, K, res = -1;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                boolean isWall = stoi(line[j]) == 1 ? true : false;

                map[i][j] = isWall;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            // 도착 시 탈출
            if(cur.y == N - 1 && cur.x == M - 1){
                res = cur.distance + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!checkPoint(nx, ny)) continue;

                if(visited[ny][nx][cur.breakWallCount]) continue;

                // 벽이 아닐 경우
                if(!map[ny][nx]) {
                    pq.add(new Point(nx, ny, cur.breakWallCount, cur.distance + 1));
                    visited[ny][nx][cur.breakWallCount] = true;
                    continue;
                }

                // 벽 부순 수 체크
                if(cur.breakWallCount >= K) continue;

                if(visited[ny][nx][cur.breakWallCount + 1]) continue;

                pq.add(new Point(nx, ny, cur.breakWallCount + 1, cur.distance + 1));
                visited[ny][nx][cur.breakWallCount + 1] = true;
            }
        }

        System.out.println(res);
    }

    public static boolean checkPoint(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    static class Point implements Comparable<Point> {
        int x, y, breakWallCount, distance;

        Point(int x, int y, int breakWallCount, int distance) {
            this.x = x;
            this.y = y;
            this.breakWallCount = breakWallCount;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return this.distance - o.distance;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
