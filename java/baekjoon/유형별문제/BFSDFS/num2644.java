package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num2644 {
    static ArrayList<ArrayList<Integer>> Edge;
    static int N, X, Y, M, result;
    static boolean[] visited;
    static Queue<Person> q = new LinkedList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());
        visited = new boolean[N];

        Edge = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Edge.add(new ArrayList<Integer>());
        }

        String[] XY = br.readLine().split(" ");
        X = stoi(XY[0]) - 1;
        Y = stoi(XY[1]) - 1;
        M = stoi(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] inputVertex = br.readLine().split(" ");

            int s = stoi(inputVertex[0]) - 1;
            int e = stoi(inputVertex[1]) - 1;

            Edge.get(s).add(e);
            Edge.get(e).add(s);
        }

        q.offer(new Person(X, 1));

        bfs();

        System.out.println(result == 0 ? -1 : result);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Person item = q.poll();

            ArrayList<Integer> itemVertext = Edge.get(item.x);
            visited[item.x] = true;

            boolean index = false;
            for (int point : itemVertext) {
                if (point == Y) {
                    result = item.depth;
                    return;
                }
                if (!visited[point]) {
                    q.add(new Person(point, item.depth +1));
                }
            }
        }

    }

    static class Person {
        int x, depth;
        Person(int x, int depth){
            this.x = x;
            this.depth = depth;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
