package 유형별문제.BFSDFS;

import java.io.*;
import java.util.*;

public class num1697_2 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        int[] dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(dist, -1);
        q.add(N);
        dist[N] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : new int[]{cur -1, cur + 1, cur * 2}) {
                if(next < 0 || next > 100000) continue;

                if(dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        System.out.println(dist[K]);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
