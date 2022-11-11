package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num1939 {
    static int N, M;
    static long res = 0, max = 0;
    static boolean visited[];
    static ArrayList<ArrayList<Edge>> Vertex = new ArrayList<ArrayList<Edge>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);

        for (int i = 0; i <= N; i++) {
            Vertex.add(new ArrayList<Edge>());
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int s = stoi(input[0]);
            int e = stoi(input[1]);
            long w = stol(input[2]);

            Vertex.get(s).add(new Edge(s, e, w));
            Vertex.get(e).add(new Edge(e, s, w));
            max = Math.max(max, w);
        }

        String[] se = br.readLine().split(" ");
        int s = stoi(se[0]);
        int e = stoi(se[1]);
        long left = 0;
        long right = max;

        while (right >= left) {
            long mid = (left + right) / 2;

            visited = new boolean[N + 1];
            if (dfs(s, e, mid, visited)) {
                left = mid + 1;
                res = Math.max(res, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static boolean dfs(int s, int e, long mid, boolean[] visited) {
        if (visited[s]) {
            return false;
        }
        visited[s] = true;

        if (s == e) {
            return true;
        }

        for (Edge item : Vertex.get(s)) {
            if (item.w >= mid) {
                if (dfs(item.e, e, mid, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static class Edge {
        int s, e;
        long w;

        Edge(int s, int e, long w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    public static long stol(String s) {
        return Long.parseLong(s);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
