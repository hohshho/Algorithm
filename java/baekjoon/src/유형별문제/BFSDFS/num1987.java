package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class num1987 {
    static int R, C, res = 0;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static String[][] map;
    static boolean[][] visited;
    static HashSet<String> temp = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
            }
        }

        visited[0][0] = true;
        temp.add(map[0][0]);
        bfs(0, 0);

        System.out.println(res);
    }

    static void bfs(int x, int y) {
        res = Math.max(res, temp.size());

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if(!checkMapPoint(nx, ny)) continue;

            if(visited[ny][nx]) continue;

            String cur = map[ny][nx];
            if(temp.contains(cur)) continue;

            temp.add(cur);
            visited[ny][nx] = true;
            bfs(nx, ny);
            visited[ny][nx] = false;
            temp.remove(cur);
        }

    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkMapPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < C && y < R;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
