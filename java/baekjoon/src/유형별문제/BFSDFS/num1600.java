package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num1600 {
    static int K, W, H, res = -1;
    static int[][] map;
    static int[] hx = {1, 2, 1, 2, -1, -2, -1, -2}, hy = {-2, -1, 2, 1, -2, -1, 2, 1};
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = stoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = stoi(st.nextToken());
        H = stoi(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];


        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0));

        int cnt = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            cnt += 1;

            for (int i = 0; i < qSize; i++) {
                Monkey cur = q.poll();

                if(cur.y == H - 1 && cur.x == W - 1) {
                    res = cnt - 1;
                    break;
                }

                // 1. 말 움직임
                if (cur.horseCnt < K) {
                    for (int j = 0; j < 8; j++) {
                        int nx = cur.x + hx[j];
                        int ny = cur.y + hy[j];

                        // 1.1) map 범위 체크
                        if (!checkMapPoint(nx, ny)) continue;

                        // 1.2) 돌 체크
                        if (map[ny][nx] == 1) continue;

                        // 1.3) 방문 체크
                        if (visited[ny][nx][cur.horseCnt + 1]) continue;

                        // 1.4) 종료
//                        if(ny == H - 1 && nx == W - 1) {
//                            res = cnt;
//                            break;
//                        }

                        visited[ny][nx][cur.horseCnt + 1] = true;
                        q.add(new Monkey(nx, ny, cur.horseCnt + 1));
                    }
                }

                if(res != -1) break;

                // 2. 일반 움직임
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    // 1.1) map 범위 체크
                    if (!checkMapPoint(nx, ny)) continue;

                    // 1.2) 돌 체크
                    if (map[ny][nx] == 1) continue;

                    // 1.3) 방문 체크
                    if (visited[ny][nx][cur.horseCnt]) continue;

                    // 1.4) 종료
//                    if(ny == H - 1 && nx == W - 1) {
//                        res = cnt;
//                        break;
//                    }

                    visited[ny][nx][cur.horseCnt] = true;
                    q.add(new Monkey(nx, ny, cur.horseCnt));
                }

                if(res != -1) break;
            }

            if(res != -1) break;
        }

        System.out.println(res);
    }

    public static boolean checkMapPoint(int x, int y) {
        return y >= 0 && x >= 0 && y < H && x < W;
    }

    static class Monkey {
        int x, y, horseCnt;

        Monkey(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.horseCnt = cnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
