package 유형별문제.구현;

import java.io.*;
import java.util.*;

// TODO: 풀이중

public class num21609_2 {
    static int N, M;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] initMap;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        initMap = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                initMap[i][j] = stoi(st.nextToken());
            }
        }

        // 기준 블록은 행이 가장 작고, 열이 가장 작은 경우 (bfs 할 때, 행, 열 순으로 해라)
        // 1. 가장 큰 블록 찾기 -> 무지개 블록 가장 많으면, 기준 블록 행이 가장 큰 것, 열이 가장 큰 것

        // 블록 제거 -> 점수는 제거점수 제곱

        // 중력 작용 -> 아래로 떨어진다. (블록이 걸리면 멈춤)

        // 반시계 회전

        // 중력 작용
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
