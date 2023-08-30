package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num16946 {
    static int N, M;
    static int[][] initMap;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static HashMap<Integer, Integer> group = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // y
        M = stoi(st.nextToken()); // x

        initMap = new int[N][M];

        // 1. 값 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                initMap[i][j] = stoi(input[j]);
            }
        }

        // 2. group화
        int groupIndex = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (initMap[i][j] >= 1) continue;

                bfs(j, i, groupIndex);
                groupIndex += 1;
            }
        }


        StringBuilder sb = new StringBuilder();
        // 3. 답 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(initMap[i][j] != 1) {
                    sb.append(0);
                    continue;
                }

                sb.append(getResult(j, i));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y, int index) {
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        initMap[y][x] = index;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if(initMap[ny][nx] != 0) continue;

                cnt += 1;
                initMap[ny][nx] = index;
                q.add(new int[]{nx, ny});
            }
        }

        group.put(index, cnt);
    }

    public static int getResult(int x, int y) {
        int result = 1;
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            if (initMap[ny][nx] == 1) continue;

            if (visited.contains(initMap[ny][nx])) continue;

            visited.add(initMap[ny][nx]);
            result += group.get(initMap[ny][nx]);
        }

        return result % 10;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
