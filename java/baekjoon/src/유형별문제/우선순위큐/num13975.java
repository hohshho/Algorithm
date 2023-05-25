package 유형별문제.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num13975 {
    static int T, K;
    static StringBuilder sb = new StringBuilder();
    static int[] items;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());

        for (int i = 0; i < T; i++) {
            K = stoi(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();

            for (int j = 0; j < K; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            Long sum = (long) 0;
            while (pq.size() > 1) {
                Long a = pq.poll();
                Long b = pq.poll();
                sum += a + b;
                pq.add(a + b);
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
