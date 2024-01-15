package 유형별문제.구현;

import java.util.*;
import java.io.*;

public class num16973 {
    static int N, M, finishX, finishY, INF = Integer.MAX_VALUE, res = INF;
    // 동, 서, 북, 남
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Node start;
    static LinkedList<int[]> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());

                if(map[i][j] == 1) {
                    map[i][j] = -1;
                    list.add(new int[] {j, i}); // x, y
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int h = stoi(st.nextToken());
        int w = stoi(st.nextToken());
        int y = stoi(st.nextToken()) - 1;
        int x = stoi(st.nextToken()) - 1;
        finishY = stoi(st.nextToken()) - 1;
        finishX = stoi(st.nextToken()) - 1;

        start = new Node(h, w, x, y, 0);

        // TODO: 도착지 도착 가능 여부 검사 후 run
        run();

        System.out.println(res == INF ? -1 : res);
    }

    public static void run() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == finishX && cur.y == finishY) {
                res = map[cur.y][cur.x];
                return;
            }

            for(int i=0; i<4; i++) {
                boolean flag = true;
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nCnt = cur.cnt + 1;

                // 좌표 범위 체크, 더 짧게 도착 한 거리 있을 경우 pass
                if(!checkMapArea(nx, ny)) continue;

                if(visited[ny][nx]) continue;

                // 사각형 범위 체크
                if(ny + cur.h - 1 >= N || nx + cur.w - 1 >= M) continue;

                // 벽 위치 체크
                for(int j=0; j < list.size(); j++) {
                    int[] point = list.get(j);

                    if(point[0] >= nx && point[0] <= nx + cur.w - 1
                            && point[1] >= ny && point[1] <= ny + cur.h - 1
                    ) flag = false;
                }

                if(!flag) continue;

                q.add(new Node(cur.h, cur.w, nx, ny, nCnt));
                map[ny][nx] = nCnt;
                visited[ny][nx] = true;
            }
        }


    }

    public static boolean checkMapArea(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static class Node {
        int h, w, x, y, cnt;

        Node(int h, int w, int x, int y, int cnt){
            this.h = h;
            this.w = w;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
