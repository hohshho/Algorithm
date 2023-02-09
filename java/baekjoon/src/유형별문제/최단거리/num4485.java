package 유형별문제.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class num4485 {
    static int N, INF = Integer.MAX_VALUE;
    static int[][] map, dist;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = stoi(br.readLine());

            if (N == 0) break;

            for (int i = 0; i < N; i++){
                String[] input = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    map[i][j] = stoi(input[j]);
                }
            }

            dikjstra();
        }
        System.out.println(sb.toString());
    }

    static void dikjstra(){
        Arrays.fill(dist, INF); // 2차원 배열 제대로 비워지는 지
        pq = new PriorityQueue<>();



    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node implements Comparable<Node> {
        int x, y, weight;

        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
