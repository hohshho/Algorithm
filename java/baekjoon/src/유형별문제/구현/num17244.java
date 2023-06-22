package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17244 {
    static int N, M, xCnt = 0;
    static int[][] map;
    static Point start, end;
    static int[][][] visited;
    static int res = 0;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                String item = inputs[j];
                int mapNum = -1;

                if (item.equals("#")) {
                    mapNum = 5;
                } else if (item.equals("S")) {
                    start = new Point(j, i);
                } else if (item.equals("E")) {
                    end = new Point(j, i);
                } else if (item.equals("X")) {
                    mapNum = xCnt;
                    xCnt += 1;
                }

                map[i][j] = mapNum;
            }
        }
        visited = new int[(int) Math.pow(2, xCnt)][M][N];
        for (int i = 0; i < (int) Math.pow(2, xCnt); i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.x, start.y, 0, 0));
        visited[0][start.y][start.x] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == end.x && cur.y == end.y && cur.check == ((1 << (xCnt)) - 1)) {
                res = cur.move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if(!checkPoint(nx, ny)) continue;

                if(map[ny][nx] == 5) continue;

                int nCheck = cur.check;
                int nMap = map[ny][nx];
                if(0 <= nMap && nMap < xCnt) nCheck |= (1<<nMap);
                if(visited[nCheck][ny][nx] > cur.move + 1) {
                    visited[nCheck][ny][nx] = cur.move + 1;
                    q.add(new Node(nx, ny, nCheck, cur.move+1));
                }
            }
        }

        System.out.println(res);
    }

    public static boolean checkPoint(int x, int y) {
        return x >= 0 && y >= 0 && y < M && x < N;
    }

    static class Node {
        int x, y, check, move;

        Node(int x, int y, int check, int move) {
            this.x = x;
            this.y = y;
            this.check = check;
            this.move = move;
        }
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
