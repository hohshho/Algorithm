package 유형별문제.그리디;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num2170 {
    static int N, res = 0;
    static PriorityQueue<Line> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");

            pq.add(new Line(stoi(input[0]), stoi(input[1])));
        }


        // 초기값 설정
        Line cur = pq.poll();
        if (cur != null) {
            res = cur.end - cur.start;
        }

        while(!pq.isEmpty()) {
            Line next = pq.poll();

            // 1. 선이 작은 경우 pass
            if(next.end <= cur.end) {
                continue;
            }

            // 2. 겹치는 경우
            if(next.start <= cur.end) {
                res += next.end - cur.end;
            } else { // 3. 겹치는 영역이 없는 경우
                res += next.end - next.start;
            }

            cur = next;
        }

        System.out.println(res);

    }

    static class Line implements Comparable<Line> {
        int start, end;

        public Line(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
