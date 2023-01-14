package 유형별문제.구현;

import java.io.*;
import java.util.*;

public class num17143 {
    static int R, C, M;
    static int answer = 0;
    static int[][] map;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static StringTokenizer st;
    static List<Shark> list = new ArrayList<>();

    static class Shark {
        int r, c, s, d, z;

        public Shark(int z) {
            super();
            this.z = z;
        }

        public Shark(int r, int c, int s, int d, int z) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Shark other = (Shark) obj;
            if (z != other.z)
                return false;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = z;
            list.add(new Shark(r, c, s, d, z));
        }

        for (int i = 1; i <= C; i++) {
            fishing(i);
            swimming();
            map = setUp();
        }
        System.out.println(answer);

    }

    static void fishing(int c) {
        for (int i = 1; i <= R; i++) {
            if (map[i][c] > 0) {
                answer += map[i][c];
                list.remove(new Shark(map[i][c]));
                map[i][c] = 0;
                return;
            }
        }
    }

    static void swimming() {
        for (int i = 0; i < list.size(); i++) {
            Shark temp = list.get(i);
            for (int j = 0; j < temp.s; j++) {
                int nr = temp.r + deltas[temp.d][0];
                int nc = temp.c + deltas[temp.d][1];
                if (isIn(nr, nc)) {
                    temp.r = nr;
                    temp.c = nc;
                } else {
                    if (temp.d % 2 == 0)
                        temp.d++;
                    else
                        temp.d--;
                    j--;
                }
            }
        }
    }

    static int[][] setUp() {
        int[][] tempMap = new int[R + 1][C + 1];
        for (int i = 0; i < list.size(); i++) {
            Shark temp = list.get(i);
            if (tempMap[temp.r][temp.c] == 0) {
                tempMap[temp.r][temp.c] = temp.z;
                continue;
            }

            i--;
            if (tempMap[temp.r][temp.c] < temp.z) {
                list.remove(new Shark(tempMap[temp.r][temp.c]));
                tempMap[temp.r][temp.c] = temp.z;
                continue;
            }

            list.remove(new Shark(temp.z));
        }
        return tempMap;
    }

    static boolean isIn(int r, int c) {
        return r > 0 && r < R + 1 && c > 0 && c < C + 1;
    }
}
