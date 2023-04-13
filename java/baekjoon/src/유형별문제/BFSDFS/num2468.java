package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num2468 {
    static int N;
    static int[][] map;
    static int max = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken()
                );
                max = Math.max(max, map[i][j]);
            }
        }

        for (int height = 1; height < max; height++) {
            visited = new boolean[N][N];

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 잠기면 pass
                    if (map[i][j] <= height) continue;

                    // dfs 방문 처리 되어있으면 pass
                    if (visited[i][j]) continue;

                    visited[i][j] = true;
                    cnt += 1;

                    Stack<Point> stack = new Stack<>();
                    stack.push(new Point(j, i));

                    while (!stack.empty()) {
                        Point cur = stack.pop();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if(!checkMapPoint(nx, ny)) continue;

                            if(visited[ny][nx]) continue;

                            if(map[ny][nx] <= height) continue;

                            visited[ny][nx] = true;
                            stack.push(new Point(nx, ny));
                        }
                    }
                }
            }

            res = Math.max(res, cnt);
        }

        System.out.println(res == 0 ? 1 : res);

    }

    static boolean checkMapPoint(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Point {
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
