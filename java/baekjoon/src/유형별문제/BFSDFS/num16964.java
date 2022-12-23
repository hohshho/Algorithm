package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num16964 {
    static int N, result = 1, idx = 1;
    static ArrayList<ArrayList<Integer>> Edge;
    static int[] checkArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());

        visited = new boolean[N +1];
        checkArr = new int[N];
        Edge = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            Edge.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int X = stoi(input[0]);
            int Y = stoi(input[1]);

            Edge.get(X).add(Y);
            Edge.get(Y).add(X);
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            checkArr[i] = stoi(input[i]);
        }

        if (checkArr[0] != 1) {
            System.out.println(0);
            return;
        }

        dfs(1);

        if (result == 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static void dfs(int x) {
        HashSet<Integer> list = new HashSet<>();
        for(int next : Edge.get(x)) {
            if(visited[next]) continue;
            list.add(next);
        }

        if (list.size() == 0) return;

        if (list.contains(checkArr[idx]) && visited[x] != true) {
            visited[x] = true;
            dfs(checkArr[idx++]);
        } else {
            result = 0;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
