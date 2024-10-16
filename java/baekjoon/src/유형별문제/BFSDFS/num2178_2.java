package 유형별문제.BFSDFS;

import java.util.*;
import java.io.*;

public class num2178_2 {
    static int N, M, result = 1000000000;
    static int[][] map;
    static int[] dx = {0 , 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");

            for(int j=0; j<M; j++){
                map[i][j] = stoi(input[j]);
            }
        }

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isInrange(nx, ny)) continue;

                if(visited[ny][nx] || map[ny][nx] == 0) continue;

                q.add(new Node(nx, ny, cur.cnt + 1));
                visited[ny][nx] = true;
                if(nx == M - 1 && ny == N - 1) result = Math.min(result, cur.cnt + 1);
            }
        }

        System.out.println(result);
    }

    static boolean isInrange(int x, int y){
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    static class Node{
        int x, y, cnt;

        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
