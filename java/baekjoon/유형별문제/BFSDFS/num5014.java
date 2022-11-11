package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num5014 {
    static ArrayList<ArrayList<Integer>> Edge;
    static int total, start, finish, up, down, result = 0;
    static Queue<Point> q = new LinkedList<Point>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        total = stoi(input[0]);
        start = stoi(input[1]) - 1;
        finish = stoi(input[2]) - 1;
        up = stoi(input[3]);
        down = stoi(input[4]);

        if(start == finish){
            System.out.println(0);
            return;
        }

        visited = new boolean[total];
        q.offer(new Point(start, 0));

        bfs();

        System.out.println(result == 0 ? "use the stairs" : result);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point item = q.poll();

            if(finish == item.floor){
                result = item.depth;
                return;
            }

            if(visited[item.floor]){
                continue;
            }

            visited[item.floor] = true;

            if(item.floor + up < total) {
                if (!visited[item.floor + up]) {
                    q.offer(new Point(item.floor + up, item.depth + 1));
                }
            }

            if(item.floor - down >= 0) {
                if (!visited[item.floor - down]) {
                    q.offer(new Point(item.floor - down, item.depth + 1));
                }
            }
        }

    }

    static class Point{
        int floor, depth;
        Point(int floor, int depth){
            this.floor = floor;
            this.depth = depth;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
