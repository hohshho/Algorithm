package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num6593 {
    static int L, R, C;
    static String[] LRC;
    static boolean check;
    static int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};

    static Queue<Point> q;
    static char[][][] map;
    static boolean[][][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        inputLRC();

        while (L + R + C != 0) {
            // run
            run();

            // 0 0 0 데이터 다시 받음
            inputLRC();
        }
    }

    public static void run() throws IOException {
        // 1. init
        init();

        // 2. insertMapData
        insertMapData();

        // 3. search
        calcEscapeTime();
        if(!check){
            System.out.println("Trapped!");
        }
    }

    public static void calcEscapeTime() {
        int nx, ny, nz;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            // end 종료 조건
            if(map[cur.z][cur.x][cur.y] == 'E') {
                check = true;
                System.out.println("Escaped in " + cur.cnt + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                nz = cur.z + dz[i];

                if(checkPoint(nx, ny, nz)){
                    if(!visited[nz][nx][ny] && map[nz][nx][ny] != '#'){
                        q.add(new Point(nx, ny, nz, cur.cnt + 1));
                        visited[nz][nx][ny] = true;
                    }
                }

            }
        }

    }

    public static boolean checkPoint(int x, int y, int z){
        return x >= 0 && y >= 0 && z >= 0 && x < R && y < C && z < L;
    }

    public static void init() {
        check = false;
        q = new LinkedList<>();
        map = new char[L][R][C];
        visited = new boolean[L][R][C];
    }

    public static void insertMapData() throws IOException {
        // input data
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                char[] data = br.readLine().toCharArray();

                for (int k = 0; k < C; k++) {
                    map[i][j][k] = data[k];

                    // 시작점 추가
                    if (data[k] == 'S') {
                        q.add(new Point(i, j, k, 0));
                        visited[i][j][k] = true;
                    }
                }
            }
            br.readLine();
        }
    }

    static class Point {
        int x, y, z, cnt;

        Point(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    public static void inputLRC() throws IOException {
        LRC = br.readLine().split(" ");

        L = stoi(LRC[0]);
        R = stoi(LRC[1]);
        C = stoi(LRC[2]);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
