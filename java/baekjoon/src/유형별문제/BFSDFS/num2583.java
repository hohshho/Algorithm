package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class num2583 {
    static int N, M, K;
    static boolean[][] map, visited; // y, x
    static ArrayList<Integer> resSize = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMK = br.readLine().split(" ");

        N = stoi(NMK[0]); // y
        M = stoi(NMK[1]); // x
        K = stoi(NMK[2]);

        map = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = stoi(input[0]);
            int y1 = N - stoi(input[1]) - 1;
            int x2 = stoi(input[2]) - 1;
            int y2 = N - stoi(input[3]);

            for (int j = y2; j <= y1; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k] = true;
                }
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && !map[i][j]) {
                    resSize.add(bfs(j, i));
                }
            }
        }

        System.out.println(resSize.size());
        Collections.sort(resSize);
        int[] resArr = resSize.stream().mapToInt(Integer::intValue).toArray();
        for (int item : resArr) {
            System.out.print(item + " ");
        }

    }

    // 빈공간 크기 반환
    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;
        int res = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(checkMapPoint(nx, ny) && !visited[ny][nx] &&!map[ny][nx]) {
                    q.add(new int[]{nx, ny});
                    res++;
                    visited[ny][nx] = true;
                }
            }
        }
        return res;
    }

    public static boolean checkMapPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }


}
