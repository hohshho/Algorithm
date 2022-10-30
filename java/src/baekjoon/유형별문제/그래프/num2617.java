package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num2617 {
    static int N, M, mid, cnt, rCnt, res;
    static ArrayList<Integer>[] Edge, rEdge;
    static boolean[] check, rCheck;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);
        mid = (N + 1) / 2;

        Edge = new ArrayList[N];
        rEdge = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Edge[i] = new ArrayList<>();
            rEdge[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int heavy = stoi(input[0]) - 1;
            int light = stoi(input[1]) - 1;

            Edge[heavy].add(light);
            rEdge[light].add(heavy);
        }

        for (int i = 0; i < N; i++) {
            clear();

//            1. dfs
//            dfs(i);
//            rdfs(i);

//            2. bfs
//            bfs(i);
//            rbfs(i);

//            3. floyd

            if (cnt >= mid || rCnt >= mid) {
                res += 1;
            }
        }

        System.out.println(res);
    }

    public static void floyd() {

    }

    public static void bfs(int num) {
        q = new LinkedList<>();
        check[num] = true;
        q.add(num);

        while (!q.isEmpty()) {
            int size = q.size();
            int cur = q.poll();

            for (int i = 0; i < size; i++) {
                for (int item : Edge[cur]) {
                    if (!check[item]) {
                        cnt += 1;
                        q.add(item);
                        check[item] = true;
                    }
                }
            }
        }
    }

    public static void rbfs(int num) {
        q = new LinkedList<>();
        rCheck[num] = true;
        q.add(num);

        while (!q.isEmpty()) {
            int size = q.size();
            int cur = q.poll();

            for (int i = 0; i < size; i++) {
                for (int item : rEdge[cur]) {
                    if (!rCheck[item]) {
                        rCnt += 1;
                        q.add(item);
                        rCheck[item] = true;
                    }
                }
            }
        }
    }

    public static void dfs(int num) {
        check[num] = true;

        for (int item : Edge[num]) {
            if (!check[item]) {
                cnt++;
                dfs(item);
            }
        }
    }

    public static void rdfs(int num) {
        rCheck[num] = true;

        for (int item : rEdge[num]) {
            if (!rCheck[item]) {
                rCnt++;
                rdfs(item);
            }
        }
    }

    public static void clear() {
        cnt = 0;
        rCnt = 0;

        check = new boolean[N];
        rCheck = new boolean[N];
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
