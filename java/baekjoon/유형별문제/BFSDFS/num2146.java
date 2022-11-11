package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class num2146 {
    static int map[][], N, result = Integer.MAX_VALUE;
    static LinkedList<int[]> q = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]) == 1 ? -1 : 0;
            }
        }

        makeArea();

        searchMinPath();

        System.out.println(result);
    }

    static void searchMinPath() {
        int cx, cy, size;

        for (int i=0; i<N; i++){
            for(int j=0; j<N; j++){

               if(map[i][j] >= 1) {
                    visited = new boolean[N][N];
                    result = Math.min(result , checkPath(i, j, map[i][j]));
               }
            }
        }
    }

    static int checkPath(int x, int y, int area) {
        int cx,cy,size = 100;
        q = new LinkedList<>();

        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cData = q.poll();

            for(int i=0; i<4; i++){
                cx = cData[0] + dx[i];
                cy = cData[1] + dy[i];
                if(checkValue(cx, cy)){
                    if(visited[cx][cy] == false && map[cx][cy] != area) {
                        visited[cx][cy] = true;
                        if(map[cx][cy] == 0) {
                            q.add(new int[]{cx, cy, cData[2] + 1});
                        } else {
                            return cData[2];
                        }
                    }
                }
            }
        }

        return size;
    }

    static void makeArea() {
        int areaIndex = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = areaIndex;
                    changeArea(i, j, areaIndex);
                    areaIndex++;
                }
            }
        }
    }

    static void changeArea(int x, int y, int index) {
        int cx, cy;

        q = new LinkedList<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] point = q.poll();
            x = point[0];
            y = point[1];
            for (int i = 0; i < 4; i++) {
                cx = x + dx[i];
                cy = y + dy[i];

                if (checkValue(cx, cy)) {
                    if (map[cx][cy] == -1) {
                        map[cx][cy] = index;
                        q.add(new int[]{cx, cy});
                    }
                }
            }
        }
    }

    static boolean checkValue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
