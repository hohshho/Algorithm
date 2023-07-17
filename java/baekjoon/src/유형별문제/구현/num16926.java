package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num16926 {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());   // y
        M = stoi(st.nextToken());   // x
        R = stoi(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        rotate(1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int depth) {
        int rotateIdx = N/2;
        int idx = 0;
        while(idx < rotateIdx) {
            
        }

        if (depth != R) {
            rotate(depth + 1);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
