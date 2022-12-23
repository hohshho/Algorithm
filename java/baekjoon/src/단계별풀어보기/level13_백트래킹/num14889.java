package 단계별풀어보기.level13_백트래킹;

import java.util.Scanner;

public class num14889 {
    static int[][] capacity;
    static int N;
    static int[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        capacity = new int[N+1][N+1];
        team = new int[N+1];

        for (int i = 1; i < capacity.length; i++) {
            for (int j = 1; j < capacity.length; j++) {
                capacity[i][j] = sc.nextInt();
            }
        }

        matching(1,0);
        System.out.println(min);
    }

    static void calc() {
        int[] start = new int[N / 2]; // 팀원 번호가 들어가는 배열
        int[] link = new int[N / 2];
        int start_count = 0; //팀원 수
        int link_count = 0;
        int start_sum = 0; //능력치의 합
        int link_sum = 0;

        for (int i = 1; i <= N; i++) {
            if (team[i] == 1) {
                start[start_count++] = i;
            } else {
                link[link_count++] = i;
            }
        }

        // i==j일때 값이 0이기 때문에 따로 처리하지 않았음.
        for (int i = 0; i < N / 2; i++) {
            for (int j = i+1; j < N / 2; j++) {
                start_sum += capacity[start[i]][start[j]] + capacity[start[j]][start[i]];
                link_sum += capacity[link[i]][link[j]] + capacity[link[j]][link[i]];
            }
        }

        min = Math.min(min, Math.abs(start_sum - link_sum));
    }

    static void matching(int start, int count) {
        if (count == (N / 2)) {
            calc();
            return;
        }

        for (int i = start; i <= N; i++) {
            team[i] = 1;
            matching(i + 1, count + 1);
            team[i] = 0;
        }
    }
}