package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num9205 {
    static int T, N;
    static Point[] stores;
    static Point start, end;
    static boolean res;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = stoi(st.nextToken());

        while (T-- > 0) {
            res = false;
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            visited = new boolean[N];
            stores = new Point[N];

            st = new StringTokenizer(br.readLine());
            start = new Point(stoi(st.nextToken()), stoi(st.nextToken()));

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i] = new Point(stoi(st.nextToken()), stoi(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            end = new Point(stoi(st.nextToken()), stoi(st.nextToken()));

            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(start.x, start.y, -1));

            while (!queue.isEmpty()) {
                int queueSize = queue.size();

                for (int i = 0; i < queueSize; i++) {
                    Point cur = queue.poll();

                    if(cur.index != -1) {
                        visited[cur.index] = true;
                    }

                    // 도착 시 종료
                    if (getDistance(cur.x, cur.y, end.x, end.y) <= 1000) {
                        res = true;
                        break;
                    }

                    for (int j = 0; j < N; j++) {
                        if(visited[j]) continue;

                        Point store = stores[j];

                        if(getDistance(cur.x, cur.y, store.x, store.y) > 1000) continue;

                        queue.add(new Point(store.x, store.y, j));
                    }

                }

                if (res) break;
            }

            System.out.println(!res ? "sad" : "happy");
        }
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Point {
        int x, y, index;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
