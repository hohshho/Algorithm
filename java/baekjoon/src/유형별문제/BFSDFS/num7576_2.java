package 유형별문제.BFSDFS;

import java.util.*;
import java.io.*;

public class num7576_2 {
    static int N, M, result = 0;
    static int[][] map, dist;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 1) {
                    q.add(new Node(j, i));
                    visited[i][j] = true;
                    dist[i][j] = 1;
                }
                else if(map[i][j] == -1) {
                    dist[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isInrange(nx, ny)) continue;

                if(visited[ny][nx] || map[ny][nx] == -1) continue;

                q.add(new Node(nx, ny));
                visited[ny][nx] = true;
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dist[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                else {
                    result = Math.max(dist[i][j], result);
                }
            }
        }

        System.out.println(result - 1);
    }

    public static boolean isInrange(int x, int y){
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
