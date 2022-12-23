package 유형별문제.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num18809 {
    static int N, M, G, R, len, res = 0;
    static int[] arrG, arrR;
    static int[] X = {-1, 0, 1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int[][] map;
    static Pos[][] visited;
    static ArrayList<Pos> list = new ArrayList<>();
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = stoi(input[0]);
        M = stoi(input[1]);
        G = stoi(input[2]);
        R = stoi(input[3]);

        map = new int[N][M];
        arrG = new int[G];
        arrR = new int[R];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(input[j]);
                if (map[i][j] == 2) {
                    list.add(new Pos(i, j, 0));
                }
            }
        }

        len = list.size();

        combination(0, 0, 0);

        System.out.println(res);
    }

    static void bfs() {
        visited = new Pos[N][M];

        for (int i = 0; i < G; i++) {
            Pos p = list.get(arrG[i]);
            q.offer(p);
            visited[p.x][p.y] = new Pos(p.time, 'G');
        }

        for (int i = 0; i < R; i++) {
            Pos p = list.get(arrR[i]);
            q.offer(p);
            visited[p.x][p.y] = new Pos(p.time, 'R');
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int time = visited[cur.x][cur.y].time;
            char color = visited[cur.x][cur.y].color;

            // Flower가 된 경우에 배양액을 확장시키면 안됨
            if (visited[cur.x][cur.y].color == 'F')
                continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + X[d];
                int ny = cur.y + Y[d];

                if (!check(nx, ny))
                    continue;

                if (visited[nx][ny] == null) {
                    visited[nx][ny] = new Pos(cur.time + 1, color);
                    q.offer(new Pos(nx, ny, cur.time + 1));
                } else if (visited[nx][ny].color == 'G' && color == 'R' && visited[nx][ny].time == time + 1) {
                    cnt++;
                    visited[nx][ny].color = 'F';
                } else if (visited[nx][ny].color == 'R' && color == 'G' && visited[nx][ny].time == time + 1) {
                    cnt++;
                    visited[nx][ny].color = 'F';
                }
            }
        }

        res = Math.max(res, cnt);
    }

    static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && map[x][y] != 0;
    }

    static void combination(int idx, int g, int r) {
        if (g == G && r == R) {
            bfs();
            return;
        }

        if (g < G) {
            for (int i = idx; i < len; i++) {
                arrG[g] = i;
                combination(i + 1, g + 1, r);
            }
        }

        if (r < R) {
            for (int i = idx; i < len; i++) {
                arrR[r] = i;
                combination(i + 1, g, r + 1);
            }
        }
    }

    static class Pos {
        int x, y, time;
        char color;

        public Pos(int time, char color) {
            this.time = time;
            this.color = color;
        }

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}