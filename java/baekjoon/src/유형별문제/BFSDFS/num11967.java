package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num11967 {
    static int N, M, res;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean[][] map, visited, isPassable;
    static HashMap<Integer, ArrayList<int[]>> switches = new HashMap<>();
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        isPassable = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            int xy = x * 1000 + y;
            int ab = a * 1000 + b;

            if (!switches.containsKey(xy)) {
                switches.put(xy, new ArrayList<>());
            }

            switches.get(xy).add(new int[]{a, b});
        }

        // 초기값
        res = 1;
        map[1][1] = true;
        visited[1][1] = true;
        isPassable[1][1] = true;
        q.add(new int[]{1, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int xy = x * 1000 + y;

            // 1. 불켜기
            if (switches.containsKey(xy)) {
                ArrayList<int[]> rooms = switches.get(xy);

                for (int[] room : rooms) {
                    int roomX = room[0];
                    int roomY = room[1];

                    if (!map[roomY][roomX]) {
                        res += 1;
                        map[roomY][roomX] = true;
                    }

                    if (isPassable[roomY][roomX] && !visited[roomY][roomX]) {
                        q.add(new int[]{roomX, roomY});
                        visited[roomY][roomX] = true;
                    }
                }
            }

            // 2. 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                // 범위 체크
                if (!checkValue(nx, ny)) continue;

                isPassable[ny][nx] = true;

                // 방문 안했고, 불이 켜져있는 곳
                if (!visited[ny][nx] && map[ny][nx]) {
                    q.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                }
            }
        }

        System.out.println(res);
    }

    public static boolean checkValue(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}