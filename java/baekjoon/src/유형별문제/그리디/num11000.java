package 유형별문제.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num11000 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        PriorityQueue<Lesson> q = new PriorityQueue();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            q.add(new Lesson(stoi(input[0]), stoi(input[1])));
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        int roomsSize = 0;
        while(!q.isEmpty()) {
            Lesson cur = q.poll();

            if(rooms.isEmpty()) {
                rooms.add(cur.end);
                if(roomsSize == 0) {
                    roomsSize++;
                }
                continue;
            }

            //  start 시간보다 작을 경우 종료 처리
            while(rooms.peek() <= cur.start) {
                rooms.poll();
            }

            rooms.add(cur.end);

            roomsSize = roomsSize < rooms.size() ? rooms.size() : roomsSize;
        }

        System.out.println(roomsSize);
    }

    static class Lesson implements Comparable<Lesson>{
        int start, end;

        Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            return this.start - o.start;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
