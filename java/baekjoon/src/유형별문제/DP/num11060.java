package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num11060 {
    static int N, INF = Integer.MAX_VALUE;
    static int[] list, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        list = new int[N + 1];
        dist = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = stoi(st.nextToken());
        }

        Arrays.fill(dist, INF);
        dist[0] = 0;
        dist[1] = 0;
        for (int i = 1; i <= N; i++) {
            int jump = list[i];
            int cur = dist[i];
            if(cur == INF) continue;
            for (int j = 1; j <= jump; j++) {
                if(j + i > N) continue;
                dist[j + i] = Math.min(dist[j + i], cur + 1);
            }
        }

        System.out.println(dist[N] == INF ? -1 : dist[N]);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
