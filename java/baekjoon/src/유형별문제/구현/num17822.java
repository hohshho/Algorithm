package 유형별문제.구현;

import java.util.*;
import java.io.*;

public class num17822 {
    static int N, M, T, x, d, k;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        T = stoi(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            x = stoi(st.nextToken());
            d = stoi(st.nextToken());
            k = stoi(st.nextToken());

            for(int j=x; j<=N; j += x) {
                rotate(j - 1);
            }

            change();

        }

        int res = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == -1) continue;

                res += map[i][j];
            }
        }

        System.out.println(res);
    }

    public static void rotate(int line) {
        // 이동 간 k

        // temp 배열 생성
        int[] temp = new int[M];

        for(int i=0; i<M; i++) {
            // 시계 방향
            if(d==0) temp[(i + k) % M] = map[line][i];
                // 반시계 방향
            else temp[(i - k < 0 ? (M + (i - k)) : i - k)] = map[line][i];
        }

        // 원본 배열 temp배열로 변경
        for(int i=0; i<M; i++) {
            map[line][i] = temp[i];
        }

    }

    public static void change() {
        boolean flag = true;
        int sum = 0;
        int cnt = 0;

        boolean[][] checked = new boolean[N][M];

        // 인접 숫자 확인
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 개수, 합 처리
                if(map[i][j] == -1) continue;

                cnt += 1;
                sum += map[i][j];

                int left = j == 0 ? map[i][M - 1] : map[i][j - 1];
                int me = map[i][j];
                int right = j == M - 1 ? map[i][0] : map[i][j + 1];

                int top = i == 0 ? -1 : map[i-1][j];
                int bottom = i == N - 1 ? -1 : map[i + 1][j];

                if(me == left || me == right || me == top || me == bottom) {
                    checked[i][j] = true;
                    flag = false;
                }
            }
        }

        // 인접 한 숫자 삭제
        if(!flag) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!checked[i][j]) continue;

                    map[i][j] = -1;
                }
            }
        }
        // 전체 평균
        else {
            float avg = (float) sum / (float) cnt;

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] == -1) continue;

                    if((float) map[i][j] < avg) {
                        map[i][j] += 1;
                    }
                    else if((float) map[i][j] > avg) {
                        map[i][j] -= 1;
                    }
                }
            }
        }

        int numa = 1;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}