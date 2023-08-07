import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class level2_장애물인식프로그램 {
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static LinkedList<Integer> list = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 0) continue;

                if (visited[j][i]) continue;

                Queue<int[]> q = new LinkedList<>();

                q.add(new int[]{i, j}); // x, y

                int cnt = 1;
                visited[j][i] = true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                        if(map[ny][nx] == 0) continue;

                        if(visited[ny][nx]) continue;

                        visited[ny][nx] = true;
                        q.add(new int[]{nx, ny});
                        cnt += 1;
                    }
                }

                list.add(cnt);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (int item : list) {
            System.out.println(item);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
