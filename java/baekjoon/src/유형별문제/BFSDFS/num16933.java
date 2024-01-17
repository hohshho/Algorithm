package 유형별문제.BFSDFS;

import java.io.*;
import java.util.*;

public class num16933 {
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMK = br.readLine().split(" ");
        N = stoi(NMK[0]);
        M = stoi(NMK[0]);
        K = stoi(NMK[0]);

        map = new int[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");

            for(int j=0; j<M; j++){
                map[i][j] = stoi(input[j]);
            }
        }




    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
