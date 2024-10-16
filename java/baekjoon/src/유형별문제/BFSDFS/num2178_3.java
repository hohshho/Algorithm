package 유형별문제.BFSDFS;

import java.io.*;
import java.util.*;

public class num2178_3 {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        Queue<Node> q = new LinkedList<Node>();
        int[][] dist = new int[N][M];
        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");

            for(int j=0; j<M; j++){
                map[i][j] = stoi(input[j]);
            }
        }

        q.add(new Node(0, 0));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isInrange(nx, ny)) continue;

                if(dist[ny][nx] > 0 || map[ny][nx] == 0) continue;

                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                q.add(new Node(nx, ny));
            }
        }

        System.out.println(dist[N-1][M-1]);

    }

    static boolean isInrange(int x, int y){
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    static class Node {
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
