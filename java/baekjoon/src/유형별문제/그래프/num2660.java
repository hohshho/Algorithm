package 유형별문제.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num2660 {
    // TODO: 다시 확인
    static int N, score[], min = 100, cnt, resCnt;
    static ArrayList<Integer>[] edge;
    static ArrayList<Integer> res = new ArrayList<>();
    static Queue<Point> q;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        edge = new ArrayList[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] ab = br.readLine().split(" ");

            int a = stoi(ab[0]) - 1;
            int b = stoi(ab[1]) - 1;
            if(a == -1 && b == -1)
                break;

            edge[a].add(b);
            edge[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N ; i++) {
            if (score[i] == min) {
                res.add(i);
                resCnt += 1;
            }
        }

        System.out.println(min + " " + resCnt);
        for (int item : res) {
            System.out.print((item +1) + " ");
        }
    }

    public static void bfs(int n) {
        visited = new boolean[N];
        q = new LinkedList<>();
        cnt = 0;
        q.add(new Point(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            Point cur = q.poll();

            cnt = Math.max(cnt, cur.w);

            for (int item : edge[cur.n]) {
                if (!visited[item]){
                    q.add(new Point(item, cur.w + 1));
                    visited[item] = true;
                }
            }
        }

        score[n] = cnt;
        min = Math.min(cnt, min);
    }

    static class Point{
        int n, w;

        Point(int n, int w){
            this.n = n;
            this.w = w;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
