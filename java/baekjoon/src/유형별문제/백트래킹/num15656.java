package 유형별문제.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num15656 {
    static int N, M;
    static int[] map;
    static boolean[] visited;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

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
        selected = new int[M];

        Arrays.sort(map);

        search(0);
        System.out.println(sb.toString());
    }

    public static void search(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            selected[cnt] = map[i];
            search(cnt + 1);
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
