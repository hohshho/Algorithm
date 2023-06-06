package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num17281 {
    static int N, res = 0, resPart;
    static int[][] list;
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        list = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                list[i][j] = stoi(st.nextToken());
            }
        }

        int[] selected = new int[9];
        selected[3] = 0;
        visited[3] = true;
        permutation(1, selected);

        System.out.println(res);
    }

    public static void permutation(int cnt, int[] selected) {
        if (cnt == 9) {
            getInning(selected);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            selected[i] = cnt;
            permutation(cnt + 1, selected);
            visited[i] = false;
        }
    }

    public static void getInning(int[] selected) {
        int[] map;
        int out = 0;
        int score = 0;
        int index = 0;

        for (int k = 0; k < N; k++) {
            int hitter;
            map = new int[4];

            while (out < 3) {
                hitter = list[k][selected[index]];

                if (hitter == 0) {
                    index = index == 8 ? 0 : index + 1;
                    out += 1;
                    continue;
                }

                // 주자 진루
                for (int i = 3; i >= 0; i--) {
                    if (map[i] == 0) continue;

                    if (!checkMap(i + hitter)) {
                        score += 1;
                        map[i] = 0;
                    } else {
                        map[i] = 0;
                        map[i + hitter] = 1;
                    }
                }

                // 현재 주자 처리
                if (hitter == 4) score += 1;
                else map[hitter] = 1;

                index = index == 8 ? 0 : index + 1;
            }

            out = 0;
//            index = index == 8 ? 0 : index + 1;
        }

        res = Math.max(res, score);
        return;
    }

    public static boolean checkMap(int n) {
        return n < 4;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
