package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class num16928 {
    static int N, K, res = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static boolean[] visited = new boolean[101];
    static LinkedList<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");

        N = stoi(NK[0]);
        K = stoi(NK[1]);

        for (int i = 0; i < N + K; i++) {
            String[] input = br.readLine().split(" ");

            int key = stoi(input[0]);
            int value = stoi(input[1]);

            map.put(key, value);
        }

        bfs();

        System.out.println(res);
    }

    public static void bfs() {
        q.add(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == 100) {
                res = cur[1];
                return;
            }

            for(int i=1; i<=6; i++){
                int next = cur[0] + i;
                if(next > 100) break;
                if(visited[next]) continue;

                if(map.containsKey(next)) {
                    next = map.get(next);
                    if(visited[next]) continue;
                }

                visited[next] = true;
                q.add(new int[] {next, cur[1] + 1});
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
