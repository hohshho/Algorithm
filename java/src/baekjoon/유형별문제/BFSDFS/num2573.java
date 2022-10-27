package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num2573 {
    static int N, M, map[][], res, time;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean flag = false, visited[][];
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> downQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                int item = stoi(input[j]);

                if (item != 0) {
                    q.add(new Point(i, j));
                }

                map[i][j] = item;
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            // 빙산 처리
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                int curHeight = map[cur.x][cur.y];
                int cnt = 0;
                visited = new boolean[N][M];

                for (int add = 0; add < 4; add++) {
                    int cx = cur.x + dx[add];
                    int cy = cur.y + dy[add];

                    if (checkValue(cx, cy)) {
                        if (map[cx][cy] == 0) {
                            cnt++;
                        }
                    }
                }

                curHeight -= cnt;

                if (curHeight < 0) {
                    curHeight = 0;
                }

                downQ.add(new Point(cur.x, cur.y, curHeight));
            }

            while (!downQ.isEmpty()) {
                Point cur = downQ.poll();

                if (cur.height > 0) {
                    q.add(cur);
                }

                map[cur.x][cur.y] = cur.height;
            }

            int part = 0;
            for (int i = 0; i < q.size(); i++) {
                Point cur = q.poll();

                if(!visited[cur.x][cur.y]){
                    dfs(cur.x, cur.y);
                    part++;
                }
                q.add(cur);
            }

            if (part > 1) {
                flag = true;
                break;
            }
            if(part == 0)
                break;
        }


        System.out.println(flag ? time : 0);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (checkValue(cx, cy)) {
                if (!visited[cx][cy] && map[cx][cy] != 0) {
                    dfs(cx, cy);
                }
            }
        }
    }


    public static boolean checkValue(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static class Point {
        int x, y, height;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
