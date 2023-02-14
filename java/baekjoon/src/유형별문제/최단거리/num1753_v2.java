package 유형별문제.최단거리;

import java.io.*;
import java.util.*;

public class num1753_v2 {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputVE = br.readLine().split(" ");
        int V = stoi(inputVE[0]);
        int E = stoi(inputVE[1]);
        int K = stoi(br.readLine());

        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);
        LinkedList<E> node[] = new LinkedList[V + 1];

        for (int i = 1; i <= V; i++) {
            node[i] = new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] inputData = br.readLine().split(" ");
            int u = stoi(inputData[0]);
            int v = stoi(inputData[1]);
            int w = stoi(inputData[2]);

            node[u].add(new E(v, w));
        }

        dijkstra(node, distance, K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++)
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
    }

    public static void dijkstra(LinkedList<E>[] node, int[] distance, int K) {
        PriorityQueue<E> q = new PriorityQueue<>();
        q.offer(new E(K, 0));
        distance[K] = 0;

        while (!q.isEmpty()) {
            E now = q.poll();
            if(distance[now.e] < now.weight) continue;

            for (E next : node[now.e]) {
                if (distance[next.e] > distance[now.e] + next.weight) {
                    distance[next.e] = distance[now.e] + next.weight;
                    q.add(new E(next.e, distance[next.e]));
                }
            }
        }
    }

    public static int stoi(String string) {
        return Integer.parseInt(string);
    }
}

class E implements Comparable<E> {
    int e, weight;

    public E(int e, int weight) {
        this.e = e;
        this.weight = weight;
    }

    @Override
    public int compareTo(E o) {
        return weight - o.weight;
    }

}
