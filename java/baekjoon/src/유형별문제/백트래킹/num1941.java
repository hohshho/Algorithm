package 유형별문제.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num1941 {
    static char[][] map = new char[5][5];
    static boolean[] visited;
    static int n = 25, r = 7, res = 0;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        combination(0, 0, new int[r]);

        System.out.println(res);
    }

    public static void combination(int idx, int cnt, int[] selected) {
        if (cnt == r) {
            bfs(selected);
            return;
        }

        for (int i = idx; i < n; i++) {
            selected[cnt] = i;
            combination(i + 1, cnt + 1, selected);
        }
    }

    public static void bfs(int[] selected) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[7];

        visited[0] = true;
        q.add(selected[0]);
        int cnt = 1, s = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int cx = cur / 5, cy = cur % 5;
            if (map[cx][cy] == 'S') s++;

            for (int i = 0; i < 4; i++) {
                for (int next = 1; next < 7; next++) {
                    if(check(cx + dx[i]) && check(cy + dy[i])) {
                        if (!visited[next] && selected[next] / 5 == cx + dx[i] && selected[next] % 5 == cy + dy[i]) {
                            visited[next] = true;
                            q.add(selected[next]);
                            cnt++;
                        }
                    }
                }
            }
        }

        if (cnt == 7 && s >= 4) {
            res++;
        }
    }

    public static boolean check(int n) {
        return n >= 0 && n < 5;
    }
}
