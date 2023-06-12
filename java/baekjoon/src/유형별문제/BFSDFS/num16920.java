package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num16920 {
    static int N, M, P;
    static int[][] map; // -1 : 벽
    // 위, 왼쪽, 오른쪽, 아래
    static int[] dx = {0, -1, 1, 0}, dy = {1, 0, 0, -1};
    static int[] players, castles;
    static Queue<Point>[] q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        P = stoi(st.nextToken());

        players = new int[P + 1];
        castles = new int[P + 1];
        map = new int[N][M];
        q = new LinkedList[P + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            players[i] = stoi(st.nextToken());
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String cur = input[j];

                // 벽처리
                if (cur.equals("#")) {
                    map[i][j] = -1;
                    continue;
                }

                if (cur.equals(".")) cur = "0";

                map[i][j] = stoi(cur);

                // 성 개수 증가
                if (map[i][j] == 0) continue;

                q[map[i][j]].add(new Point(j, i));
            }
        }

        boolean[][] visited = new boolean[N][M];
        boolean check = true;
        while (check) {
            check = false;

            for (int i = 1; i <= P; i++) {
                Queue<Point> partQ = q[i];
                int len = players[i];

                while (!partQ.isEmpty() && len-- > 0) {
                    int qSize = q[i].size();

                    while (qSize-- > 0) {
                        Point cur = partQ.poll();

                        for (int j = 0; j < 4; j++) {
                            int nx = cur.x + dx[j];
                            int ny = cur.y + dy[j];

                            if (!checkMapArrange(nx, ny)) continue;

                            if (map[ny][nx] != 0 || map[ny][nx] == -1) continue;

                            partQ.add(new Point(nx, ny));
                            map[ny][nx] = i;
                            check = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1 && map[i][j] != 0) {
                    castles[map[i][j]]++;
                }
            }
        }

        for (int i = 1; i <= P; i++) {
            System.out.print(castles[i] + " ");
        }
    }

    public static boolean checkMapArrange(int x, int y) {
        return x >= 0 && y >= 0 && y < N && x < M;
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
