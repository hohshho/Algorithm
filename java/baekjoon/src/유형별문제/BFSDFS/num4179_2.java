package 유형별문제.BFSDFS;

import java.util.*;
import java.io.*;

public class num4179_2 {
    static int R, C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dist1, dist2;
    static char[][] map;
    static Node jihun;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new char[R][C];
        dist1 = new int[R][C];
        dist2 = new int[R][C];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);

            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
                if (input[j] == 'J') {
                    jihun = new Node(j, i);
                    dist2[i][j] = 0;
                }
                if (input[j] == 'F') {
                    q.add(new Node(j, i));
                    dist1[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isInrange(nx, ny)) continue;

                if(map[ny][nx] == '#' || dist1[ny][nx] >= 0) continue;

                q.add(new Node(nx, ny));
                dist1[ny][nx] = dist1[cur.y][cur.x] + 1;
            }
        }

        q.add(new Node(jihun.x, jihun.y));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isInrange(nx, ny)){
                    // 종료
                    System.out.println(dist2[cur.y][cur.x] + 1);
                    return;
                }

                if(dist2[ny][nx] >= 0 || map[ny][nx] == '#') continue;
                if(dist1[ny][nx] != -1 && dist1[ny][nx] <= dist2[cur.y][cur.x] + 1) continue;

                dist2[ny][nx] = dist2[cur.y][cur.x] + 1;
                q.add(new Node(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean isInrange(int x, int y){
        return x>=0 && y >= 0 && x < C && y < R;
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
