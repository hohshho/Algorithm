package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num2665 {
    static int N, INF = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
    static int[][] map, dist;
    static int[] dx = new int[]{0, 0, 1, -1}, dy = new int[]{1, -1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
                dist[i][j] = INF;
            }
        }

        bfs();

        System.out.println(res);

    }

    public static void bfs() {
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++ ){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(checkMapRange(nx, ny) && dist[nx][ny] > dist[cx][cy]) {
                    dist[nx][ny] = dist[cx][cy];

                    if(map[nx][ny] == 0) {
                        dist[nx][ny] += 1;
                    }

                    q.add(new int[]{nx, ny});
                }

            }

        }

        res = dist[N-1][N-1];
    }

    public static boolean checkMapRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
