package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num17144 {
    static int R, C, T, res;
    static int[][] maps;
    static Point upPoint, downPoint;
    static int[] dxU = {1, 0, -1, 0},
            dyU = {0, -1, 0, 1},
            dxD = {1, 0, -1, 0},
            dyD = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        T = stoi(st.nextToken());

        maps = new int[R][C]; // Y, X

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                maps[i][j] = stoi(st.nextToken());

                if (maps[i][j] != -1) continue;

                if (upPoint == null) {
                    upPoint = new Point(j, i);
                } else {
                    downPoint = new Point(j, i);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadDust();

            runAirCleaner();
        }

        System.out.println(getDust());
    }

    public static void spreadDust() {
        int[][] newMaps = new int[R][C];

        for (int i = 0; i < R; i++) {
            // TODO:
            for (int j = 0; j < C; j++) {
                // 공기청정기 위치 유지
                if (maps[i][j] < 0) {
                    newMaps[i][j] = maps[i][j];
                    continue;
                }

                int count = 0;
                int cx = j, cy = i, cAmount = maps[i][j];
                LinkedList<Point> list = new LinkedList<>();

                for (int k = 0; k < 4; k++) {
                    int nx = cx + dxU[k];
                    int ny = cy + dyU[k];

                    if (!checkMap(nx, ny)) continue;

                    if (maps[ny][nx] == -1) continue;

                    count += 1;
                    list.add(new Point(nx, ny));
                }

                if (count == 0) continue;

                for (Point point : list) {
                    newMaps[point.y][point.x] += cAmount / 5;
                }

                newMaps[i][j] += cAmount - ((cAmount / 5) * count);
            }
        }

        maps = newMaps.clone();

    }

    public static boolean checkMap(int x, int y) {
        return x >= 0 && x < C && y >= 0 && y < R;
    }

    public static void runAirCleaner() {
        int[][] newMaps = new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                newMaps[i][j] = maps[i][j];
            }
        }

        Point cur = new Point(upPoint.x, upPoint.y);
        // up
        for (int i = 0; i < 4; ) {
            cur.x += dxU[i];
            cur.y += dyU[i];

            // 제자리로 돌아 올 경우 탈출
            if (cur.x == upPoint.x && cur.y == upPoint.y) break;

            // 방향 전환
            if (!checkMap(cur.x, cur.y)) {
                cur.x -= dxU[i];
                cur.y -= dyU[i];
                i++;
                continue;
            }

            // 공기 청정기 위치
            if (maps[cur.y - dyU[i]][cur.x - dxU[i]] != -1) {
                newMaps[cur.y][cur.x] = maps[cur.y - dyU[i]][cur.x - dxU[i]];
            }else {
                newMaps[cur.y][cur.x] = 0;
            }
        }

        cur = new Point(downPoint.x, downPoint.y);
        // down
        for (int i = 0; i < 4; ) {
            cur.x += dxD[i];
            cur.y += dyD[i];

            // 제자리로 돌아 올 경우 탈출
            if (cur.x == downPoint.x && cur.y == downPoint.y) break;

            // 방향 전환
            if (!checkMap(cur.x, cur.y)) {
                cur.x -= dxD[i];
                cur.y -= dyD[i];
                i++;
                continue;
            }

            // 제자리로 돌아 올 경우 탈출
            if (cur.x == downPoint.x && cur.y == downPoint.y) break;

            // 공기 청정기 위치
            if (maps[cur.y - dyD[i]][cur.x - dxD[i]] != -1) {
                newMaps[cur.y][cur.x] = maps[cur.y - dyD[i]][cur.x - dxD[i]];
            } else {
                newMaps[cur.y][cur.x] = 0;
            }
        }

        maps = newMaps.clone();
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getDust() {
        int dustAmount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i][j] <= 0) continue;

                dustAmount += maps[i][j];
            }
        }

        return dustAmount;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
