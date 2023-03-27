package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num16234 {
    static int N, L, R;
    static int[][] map;
    static int res = 0;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NLR = br.readLine().split(" ");
        N = stoi(NLR[0]);
        L = stoi(NLR[1]);
        R = stoi(NLR[2]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
            }
        }

        checkMap();

        System.out.println(res);

    }

    public static void checkMap() {
        boolean flag = true;

        while (flag) {
            boolean[][] visited = new boolean[N][N];
            Queue<Point> queue = new LinkedList<>();
            HashSet<Integer> set;

            flag = false;
            // 1. open된 경로 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    boolean openFlag = false;
                    int totalSize = 0;
                    set = new HashSet<>();

                    if(visited[i][j]) continue;

                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if(!checkMapArea(nx, ny)) continue;

                        if (checkOpenLine(map[i][j], map[ny][nx]) && !visited[ny][nx]) {
                            openFlag = true;
                            flag = true;
                            queue.add(new Point(j, i));
                            visited[i][j] = true;
                            break;
                        }
                    }

                    // 2. Open된 경로 있는 경우 인구 분배
                    if (openFlag) {
                        while(!queue.isEmpty()) {
                            Point cur = queue.poll();
                            totalSize += map[cur.y][cur.x];
                            if(!set.contains(cur.y * N + cur.x)) set.add(cur.y * N + cur.x);

                            for (int k = 0; k < 4; k++) {
                                int nx = cur.x + dx[k];
                                int ny = cur.y + dy[k];

                                if(!checkMapArea(nx, ny)) continue;

                                if (checkOpenLine(map[cur.y][cur.x], map[ny][nx]) && !visited[ny][nx]) {
                                    queue.add(new Point(nx, ny));
                                    visited[ny][nx] = true;
                                }
                            }
                        }

                        for (int hash : set) {
                            int y = hash / N, x = hash % N;
                            map[y][x] = totalSize / set.size();
                        }
                    }
                }
            }

            // 3. 인구 이동이 있던 경우 res + 1
            if (flag) res += 1;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkMapArea(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static boolean checkOpenLine(int a, int b) {
        int diff = Math.abs(a - b);
        return L <= diff && diff <= R;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
