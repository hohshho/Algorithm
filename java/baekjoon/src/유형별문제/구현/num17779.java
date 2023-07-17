package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num17779 {
    // initX, initY = 왼쪽 꼭지점
    static int N, initX, initY, d1, d2, res = Integer.MAX_VALUE, totalPeople = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = stoi(st.nextToken());
                totalPeople += arr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                initX = i;
                initY = j;
                d1 = 1;
                d2 = 1;

                if (!checkInitValue(initX, initY, d1, d2)) continue;

                for(int k = 0; k < N; k++){
                    for(int l = 0; l < N; l++){
                        if (!checkInitValue(initX, initY, d1 + k, d2 + l)) continue;

                        if(initX == 2 && initY == 4 && d1 + k == 2 && d2 + l == 1) {
//                            System.out.println("ss");
                        }

                        checkSum(initX, initY, d1 + k, d2 + l);
                    }

                }
            }
        }

        System.out.println(res);
    }

    public static void checkSum(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] peopleSum = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                peopleSum[0] += arr[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j]) break;
                peopleSum[1] += arr[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                peopleSum[2] += arr[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                peopleSum[3] += arr[i][j];
            }
        }

        // 5 구역 인구수
        peopleSum[4] = totalPeople;

        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        // 정렬
        Arrays.sort(peopleSum);

        // 최대 - 최소
        res = Math.min(res, peopleSum[4] - peopleSum[0]);
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkInitValue(int x, int y, int d1, int d2) {
        // 왼쪽 꼭지점에서 오른쪽 꼭지점으로 갈 수 없는 경우 선거구를 나눌 수 없음
        if (x + d1 + d2 >= N || y - d1 < 0 || y + d2 >= N) return false;

        return true;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
