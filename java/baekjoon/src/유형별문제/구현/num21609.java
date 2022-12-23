package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class num21609 {
    static int N, M, dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1}, res = 0;
    static int[][] map; // -1 : 검은색 블록, -2 : 무지개 블록, 0 : 값 없음, 1 ~ : 일반 블록
    static PriorityQueue<Block> pq;
    static Queue<Point> q, rainbowQueue;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                int block = stoi(input[j]);

                if (block == 0) {
                    map[i][j] = -2;
                    continue;
                }

                map[i][j] = block;
            }
        }
        while (true) {
            // 블록 그룹 찾기
            if (!findGroup()) break;

            // 블록 제거 및 점수 획득
            getResult();
            // 중력 작용
            applyGravity();
            // 반시계 회전
            rotateMap();
            // 중력 작용
            applyGravity();
        }

        System.out.println(res);
    }

    public static void getResult() {
        Block block = pq.poll();
        q = new LinkedList<>();
        visited = new boolean[N][N];
//        map[block.base.y][block.base.x] = 0;
        q.add(new Point(block.base.x, block.base.y));
        int origin = map[block.base.y][block.base.x];

        while (!q.isEmpty()) {
            Point cur = q.poll();
            visited[cur.y][cur.x] = true;
            map[cur.y][cur.x] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (!checkValue(nx, ny)) continue;
                if (visited[ny][nx]) continue;
                if (origin != map[ny][nx] && map[ny][nx] != -2) continue;

                q.add(new Point(nx, ny));
            }
        }

        res += block.cnt * block.cnt;
    }

    public static void applyGravity() {
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if(map[j][i] == 0 || map[j][i] == -1) continue;
                int dest = j + 1;
                while(true){
                    if(dest == N) break;
                    if(map[dest][i] == 0) dest++;
                    else break;
                }
                if(dest == j+1) continue;
                map[dest-1][i] = map[j][i];
                map[j][i] = 0;
            }
        }

    }

    // TODO: 회전하는건 정리해두자
    // TODO: 맞는지도 확인
    public static void rotateMap() {
        int[][] tmp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[N - 1 -j][i] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }

    public static boolean findGroup() {
        pq = new PriorityQueue<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[j][i] && map[j][i] > 0 && map[j][i] <= M) {
                    q = new LinkedList<>();
                    rainbowQueue = new LinkedList<>();
                    q.add(new Point(i, j));
                    visited[j][i] = true;
                    int rainbowCnt = 0;
                    int cnt = 1;
                    int origin = map[j][i];

                    while (!q.isEmpty()) {
                        Point cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = dx[k] + cur.x;
                            int ny = dy[k] + cur.y;

                            if (!checkValue(nx, ny) || visited[ny][nx] || map[ny][nx] == 0) continue;

                            if (map[ny][nx] == -2 || map[ny][nx] == origin) {
                                q.add(new Point(nx, ny));
                                visited[ny][nx] = true;
                                cnt++;

                                if (map[ny][nx] == -2) {
                                    rainbowQueue.add(new Point(nx, ny));
                                    rainbowCnt++;
                                }
                            }
                        }

                    }

                    if(cnt > 1) {
                        pq.add(new Block(new Point(i, j), rainbowCnt, cnt));
                    }
                    // 무지개 칸 visited 원상 복구
                    while (!rainbowQueue.isEmpty()) {
                        Point cur = rainbowQueue.poll();

                        visited[cur.y][cur.x] = false;
                    }

                }
            }
        }
        return pq.size() > 0 ? true : false;
    }

    static boolean checkValue(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Block implements Comparable<Block> {
        Point base;
        int rainbowCnt, cnt;

        Block(Point base, int rainbowCnt, int cnt) {
            this.base = base;
            this.rainbowCnt = rainbowCnt;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Block o) {
            // 1. 크기가 가장 큰 블록
            if (this.cnt != o.cnt) return o.cnt - this.cnt;

            // 2. 무지개 블록이 많은 블록
            if (this.rainbowCnt != o.rainbowCnt) return o.rainbowCnt - this.rainbowCnt;

            // 3. 행이 큰 블록
            if (this.base.y != o.base.y) return o.base.y - this.base.y;

            // 4. 열이 큰 블록
            return o.base.x - this.base.x;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
