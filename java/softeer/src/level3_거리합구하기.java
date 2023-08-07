import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class level3_거리합구하기 {
    static int N;
    static long LNF = (long) 987654321;
    static LinkedList<LinkedList<Node>> adj = new LinkedList<LinkedList<Node>>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for (int i = 0; i < N; i++) {
            adj.add(new LinkedList<>());
        }

        dist = new long[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], LNF);
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = stoi(st.nextToken()) - 1;
            int e = stoi(st.nextToken()) - 1;
            int weight = stoi(st.nextToken());

//            adj.get(s).add(new Node(e, weight));
            dist[s][e] = weight;
            dist[e][s] = weight;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    dist[j][i] = Math.min(dist[j][i], dist[j][k] + dist[k][i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            long res = 0;

            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                res += dist[i][j];
            }

            System.out.println(res);
        }

    }

    public static class Node implements Comparable<Node> {
        int e;
        long weight;

        Node(int e, long weight) {
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.weight - o.weight);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
