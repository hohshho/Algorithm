package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num17070 {
    static int N, res = 0;
    static int[][] map;
    // 0 : 가로, 1 : 대각선, 2 : 세로
    static int[] dx = {1, 1, 0}, dy = {0, 1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        visited[1][2] = true;
        checkPipe(2, 1, 0);

        System.out.println(res);
    }

    public static void checkPipe(int x, int y, int direction) {
        if (x == N && y == N) {
            res += 1;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (direction == 0 && i == 2) continue;

            if (direction == 2 && i == 0) continue;

            if (!checkMap(nx, ny)) continue;

            if (visited[ny][nx]) continue;

            if(map[ny][nx] == 1) continue;

            if(i == 1 && (map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1)) continue;

            visited[ny][nx] = true;
            checkPipe(nx, ny, i);
            visited[ny][nx] = false;
        }
    }

    public static boolean checkMap(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
