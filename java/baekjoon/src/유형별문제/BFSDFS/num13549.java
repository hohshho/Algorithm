package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num13549 {
    static int N, K, res = 100001;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());


        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));
        set.add(N);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                set.add(cur.n);

                if (cur.n == K) {
                    res = Math.min(res, cur.time);
                }

                if (check(cur.n * 2)) {
                    q.add(new Point(cur.n * 2, cur.time));
                }

                if (check(cur.n + 1)) {
                    q.add(new Point(cur.n + 1, cur.time + 1));
                }

                if (check(cur.n - 1)) {
                    q.add(new Point(cur.n - 1, cur.time + 1));
                }
            }
        }

        System.out.println(res);

    }

    public static boolean check(int n) {
        return !set.contains(n) && n >= 0 && n <= 100000;
    }

    static class Point {
        int n, time;

        Point(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
