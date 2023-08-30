package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num21610 {
    public static int n, m;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static ArrayList<Node> cloud;
    public static int[][] map;
    public static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Node> cloud = new ArrayList<>();
        cloud.add(new Node(n - 1, 0));
        cloud.add(new Node(n - 1, 1));
        cloud.add(new Node(n - 2, 0));
        cloud.add(new Node(n - 2, 1));

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            boolean[][] check = new boolean[n][n];
            // 구름 이동
            for (Node node : cloud) {
                int nx = node.x + dx[dir] * (s % n);
                int ny = node.y + dy[dir] * (s % n);
                if (nx < 0) {
                    nx = n - Math.abs(nx);
                } else if (nx >= n) {
                    nx -= n;
                }

                if (ny < 0) {
                    ny = n - Math.abs(ny);
                } else if (ny >= n) {
                    ny -= n;
                }

                map[nx][ny] += 1;
                check[nx][ny] = true;

                node.x = nx;
                node.y = ny;
            }

            int[][] map_copy = new int[n][n];
            for (Node node : cloud) {
                int cnt = 0;

                for (int d = 2; d <= 8; d += 2) {
                    int nx = node.x + dx[d];
                    int ny = node.y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (map[nx][ny] > 0) {
                        cnt++;
                    }
                }
                map_copy[node.x][node.y] = cnt;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] += map_copy[i][j];
                }
            }
            cloud.clear();

            // 구름 생성
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= 2 && !check[i][j]) {
                        cloud.add(new Node(i, j));
                        map[i][j] -= 2;
                    }
                }
            }


        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += map[i][j];
            }
        }

        System.out.println(ans);
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
