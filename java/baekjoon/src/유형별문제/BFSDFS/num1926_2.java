package 유형별문제.BFSDFS;

import java.io.*;
import java.util.*;

public class num1926_2 {
    static int N, M, cnt = 0, max = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt += 1;
                    int tempSize = 1;

                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(j, i));
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        Node cur = q.poll();

                        for(int k=0; k<4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if(!checkMapArea(nx, ny)) continue;

                            if(map[ny][nx] == 0 || visited[ny][nx]) continue;

                            q.add(new Node(nx,ny));
                            visited[ny][nx] = true;
                            tempSize += 1;
                        }

                    }

                    max = Math.max(tempSize, max);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static boolean checkMapArea(int x, int y){
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    static class Node{
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
