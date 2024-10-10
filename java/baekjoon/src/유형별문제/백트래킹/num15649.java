package 유형별문제.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15649
public class num15649 {
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        visited = new boolean[N + 1];
        permutation(0, new int[M]);
    }

    public static void permutation(int cnt, int[] selected) {
        if(cnt >= M) {
            for(int item : selected) {
                System.out.print(item + " ");
            }
            System.out.println("");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;

            selected[cnt] = i;
            visited[i] = true;
            permutation(cnt + 1, selected);
            visited[i] = false;
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
