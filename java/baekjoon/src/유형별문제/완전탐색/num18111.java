package 유형별문제.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/18111
public class num18111 {
    static int N, M, B, min, max;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        B = stoi(st.nextToken());

        map = new int[N][M];

        min = 256;
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int resultSec = Integer.MAX_VALUE;
        int blockLen = 0;

        // i = 높이
        for (int i = min; i <= max; i++) {
            int curSecond = 0;
            int curBlockCnt = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 높이가 높은 경우 추가, 1초
                    if(i > map[j][k]) {
                        curSecond += i - map[j][k];
                        curBlockCnt -= i - map[j][k];
                    }
                    // 높이 낮은경우 제거, 2초
                    else if(i < map[j][k]) {
                        curSecond += 2 * (map[j][k] - i);
                        curBlockCnt += map[j][k] - i;
                    }
                }
            }

            if(curBlockCnt < 0) continue;

            if(resultSec >= curSecond) {
                blockLen = Math.max(blockLen, i);
                resultSec = curSecond;
            }
        }

        System.out.println(resultSec + " " + blockLen);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
