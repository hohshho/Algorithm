package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num17135 {
    static int N, M, D, res = 0;
    static HashSet<String> initEnemies = new HashSet<>();
    static int[][] initMap;
    static HashSet<String> enemies = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        D = stoi(st.nextToken());

        initMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                initMap[i][j] = stoi(st.nextToken());

                if (initMap[i][j] == 1) initEnemies.add((j + 1) + "," + (i + 1));
            }
        }

        getRes(1, 0, new int[3]);

        System.out.println(res);
    }

    public static void getRes(int idx, int cnt, int[] selected) {
        if (cnt == 3) {
            simulation(selected);
            return;
        }

        for (int i = idx; i <= M; i++) {
            selected[cnt] = i;
            getRes(i + 1, cnt + 1, selected);
        }
    }

    public static void simulation(int[] archeres) {
        initSimulationData();
        int cnt = 0;

        while (enemies.size() != 0) {
            HashSet<String> newEnemies = new HashSet<>();

            HashSet<String> removeList = new HashSet<>();
            // attack
            for (int archer : archeres) {
                int archerX = archer, archerY = N + 1;
                int enemyX = 0, enemyY = 0, enemyDist = Integer.MAX_VALUE;
                for (String enemy : enemies) {
                    String[] input = enemy.split(",");
                    int tempX = stoi(input[0]);
                    int tempY = stoi(input[1]);
                    int tempDistance = getDistance(archerX, archerY, tempX, tempY);

                    if (tempDistance > D) continue;

                    if ((tempDistance < enemyDist) || (tempDistance == enemyDist && tempX < enemyX)) {
                        enemyX = tempX;
                        enemyY = tempY;
                        enemyDist = tempDistance;
                    }
                }

                removeList.add(enemyX + "," + enemyY);
            }

            for (String remove : removeList) {
                String[] input = remove.split(",");
                if (enemies.contains(input[0] + "," + input[1])) {
                    enemies.remove(input[0] + "," + input[1]);
                    cnt += 1;
                }
            }

            // move
            for (String enemy : enemies) {
                String[] enemyPoint = enemy.split(",");
                int x = stoi(enemyPoint[0]);
                int y = stoi(enemyPoint[1]) + 1;

                if (y != N + 1) newEnemies.add(x + "," + y);
            }

            enemies = newEnemies;
        }

        res = Math.max(cnt, res);
    }

    public static void initSimulationData() {
        enemies = new HashSet<>();

        for (String enemy : initEnemies) {
            enemies.add(enemy);
        }

    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkMapArrange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
