package 유형별문제.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class num1417 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());

        int dasom = stoi(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            pq.add(stoi(br.readLine()));
        }

        int res = 0;

        if (!pq.isEmpty()) {
            while (dasom <= pq.peek()) {
                int cur = pq.poll();
                pq.add(cur - 1);
                res += 1;
                dasom += 1;
            }
        }

        System.out.println(res);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
