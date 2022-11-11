package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class num9466 {
    static int T, cnt, idx, results[];
    static ArrayList<ArrayList<Integer>> adj;
    static int N;
    static boolean[] finished;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = stoi(br.readLine());
        results = new int[T];

        for (int i = 0; i < T; i++) {
            idx = i;
            N = stoi(br.readLine());
            String[] input = br.readLine().split(" ");

            finished = new boolean[N];
            visited = new boolean[N];

            cnt = 0;

            adj = new ArrayList<>();
            for(int j = 0; j< N; j++){
                adj.add(new ArrayList<Integer>());
            }

            for (int j = 0; j < N; j++) {
                int x = j, y = stoi(input[j]) - 1;
                adj.get(x).add(y);
            }

            for (int j = 0; j < N; j++) {
                if(!finished[j]) {
                    dfs(j);
                }
            }
            System.out.println(N - results[idx]);
        }

    }

    public static void dfs(int num) {
        if(finished[num]) return;

        // 방문한 적 있는 곳
        if(visited[num]) {
            finished[num] = true;

            // dfs로 탐색하면서 싸이클에 속하는 노드 개수 증가
            results[idx]++;
        }

        visited[num] = true;
        ArrayList<Integer> list = adj.get(num);

        for(int item : list){
            dfs(item);
            finished[num] = true;

            // dfs돌려줄 때 초기화 하면 시간 초과 -> dfs에서 벗어나면 다시 돌려줌
            visited[num] = false;
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
