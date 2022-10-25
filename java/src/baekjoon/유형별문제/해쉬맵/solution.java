package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class solution {
    static int N, M;
    static long answer;
    static LinkedList<int[]> q = new LinkedList<>();
    static LinkedList<int[]> startPointList = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int[][] indexMaps;
    static boolean[][] visited;

    public long solution(int[][] maps) {
        answer = 0;

        N = maps.length;
        M = maps[0].length;

        makeArea(maps);

        calcMap();

        return answer;
    }

    static void calcMap() {
        visited = new boolean[N][M];

        while(!startPointList.isEmpty()){
            int result = 0;

            int[] startPoint = startPointList.poll();
            int sx = startPoint[0];
            int sy = startPoint[1];

            q = new LinkedList<>();
            q.add(new int[]{sx, sy});

            while(!q.isEmpty()) {
                int[] point = q.poll();
                int px = point[0];
                int py = point[1];
                int value = 4; // 초기값
                visited[px][py] = true;

                for (int i = 0; i < 4; i++) {
                    int cx = px + dx[i];
                    int cy = py + dy[i];

                    if (checkValue(cx, cy)) {
                        if (indexMaps[cx][cy] != 0) {
                            value--;

                            if(!visited[cx][cy]){
                                q.add(new int[]{cx, cy});
                                visited[cx][cy] = true;
                            }
                        }
                    }
                }

                result += value;
            }

            answer = result > answer ? result : answer;
        }

    }


    static void makeArea(int[][] maps) {
        visited = new boolean[N][M];
        indexMaps = new int[N][M];
        int area = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    indexMaps[i][j] = 0;
                }
                if (maps[i][j] != 0 && visited[i][j] == false) {
                    indexMaps[i][j] = area;
                    startPointList.add(new int[] {i, j});
                    changeArea(i, j, area, maps);
                    area++;
                }
            }
        }
    }

    static void changeArea(int x, int y, int area, int[][] maps) {
        q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] point = q.poll();
            x = point[0];
            y = point[1];
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (checkValue(cx, cy)) {
                    if (maps[cx][cy] != 0 && !visited[cx][cy]) {
                        indexMaps[cx][cy] = area;
                        visited[cx][cy] = true;
                        q.add(new int[]{cx, cy});
                    }
                }
            }
        }
    }

    static boolean checkValue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        solution a = new solution();
        System.out.println(a.solution(new int[][]{{1, 0, 1, 1}, {0, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 0, 0}}));

    }
}
