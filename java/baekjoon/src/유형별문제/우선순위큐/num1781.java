package 유형별문제.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int deadLine = stoi(st.nextToken());
            int cupLamenCnt = stoi(st.nextToken());

            pq.add(new Problem(deadLine, cupLamenCnt));
        }

        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            Problem cur = pq.poll();
            result.add(cur.cupLamenCnt);

            if (cur.deadLine < result.size()) {
                result.poll();
            }
        }

        int res = 0;
        while(!result.isEmpty()) {
            int poll = result.poll();
            res += poll;
        }
        System.out.println(res);

    }

    static class Problem implements Comparable<Problem> {

        int deadLine, cupLamenCnt;

        Problem(int deadLine, int cupLamenCnt) {
            this.deadLine = deadLine;
            this.cupLamenCnt = cupLamenCnt;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadLine != o.deadLine) return this.deadLine - o.deadLine;
            return o.cupLamenCnt - this.cupLamenCnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
