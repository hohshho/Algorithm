package 유형별문제.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num15654 {
    static int N, M;
    static int[] map;
    static boolean[] visited;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = stoi(st.nextToken());
        }
        visited = new boolean[N];
        selected = new int[M];

        Arrays.sort(map);

        search(0);
    }

    public static void search(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            selected[cnt] = map[i];
            search(cnt + 1);
            visited[i] = false;
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
