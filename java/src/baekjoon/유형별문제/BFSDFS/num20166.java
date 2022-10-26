package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num20166 {
    static int N, M, K, fsLen = 0;
    static String keys[];
    static HashMap<String, Integer> favoriteStrings = new HashMap<>();
    static String[][] map;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMK = br.readLine().split(" ");
        N = stoi(NMK[0]);
        M = stoi(NMK[1]);
        K = stoi(NMK[2]);

        map = new String[N][M];
        keys = new String[K];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < K; i++) {
            String inputString = br.readLine();
            fsLen = Math.max(fsLen, inputString.length());
            favoriteStrings.put(inputString, 0);
            keys[i] = inputString;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                makeString(i, j, 1, map[i][j]);
            }
        }

        for(String key : keys){
            System.out.println(favoriteStrings.get(key));
        }

    }

    public static void makeString(int x, int y, int depth, String item) {
        if(favoriteStrings.containsKey(item)){
            favoriteStrings.put(item, favoriteStrings.get(item) + 1);
        }

        // 종료 조건
        if (depth == fsLen) {
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int cx = checkMapValue(dx[i] + x, N);
            int cy = checkMapValue(dy[i] + y, M);

            String cItem = item + map[cx][cy];

            makeString(cx, cy, depth + 1, cItem);
        }

    }

    public static int checkMapValue(int value, int checkValue) {
        if(value >= checkValue) {
            return 0;
        }else if(value < 0) {
            return checkValue - 1;
        }

        return value;
    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
