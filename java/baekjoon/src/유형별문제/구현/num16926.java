package 유형별문제.구현;

import java.util.*;
import java.io.*;

public class num16926 {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        R = stoi(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0; i<R; i++) {
            rotate();
        }

        for(int i=0; i<N; i++) {
            for(int j=0;j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate() {
        int[][] temp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[M - j -1][i] = map[i][j];
            }
        }

        map = temp;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
