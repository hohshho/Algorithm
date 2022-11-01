package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num10026 {
    static int N, map[][], map2[][], idx, cnt;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new int[N][N];
        map2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            // 파랑 : 1, 빨강 2, 초록 3
            for (int j = 0; j < N; j++) {
                String item = input[j];

                if (item.equals("B")) {
                    map[i][j] = 1;
                    map2[i][j] = 1;
                } else if (item.equals("R")) {
                    map[i][j] = 2;
                    map2[i][j] = 2;
                } else if (item.equals("G")) {
                    map[i][j] = 3;
                    map2[i][j] = 2;
                }
            }
        }

        bfs();
        bfs();
    }

    public static void clear() {
        visited = new boolean[N][N];
        q = new LinkedList<>();
        cnt = 0;
    }

    public static void bfs() {
        clear();
        idx += 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    q.add(new int[]{i, j});
                    cnt += 1;

                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        visited[point[0]][point[1]] = true;
                        int item = map[point[0]][point[1]];
                        if(idx == 2){
                            item = map2[point[0]][point[1]];
                        }

                        for (int k = 0; k < 4; k++) {
                            int cx = point[0] + dx[k];
                            int cy = point[1] + dy[k];

                            if (check(cx, cy)) {
                                if(visited[cx][cy]) {
                                    continue;
                                }
                                if(idx == 1) {
                                    if (!visited[cx][cy] && item == map[cx][cy]) {
                                        q.add(new int[]{cx, cy});
                                    }
                                }else {
                                    if (!visited[cx][cy] && item == map2[cx][cy]) {
                                        q.add(new int[]{cx, cy});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(cnt + " ");
    }

    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
