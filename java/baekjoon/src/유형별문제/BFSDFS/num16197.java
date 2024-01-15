package 유형별문제.BFSDFS;

import java.util.*;
import java.io.*;

public class num16197 {
    static int N, M, INF = Integer.MAX_VALUE, res = INF;
    static char[][] map;
    static LinkedList<Coin> coinList = new LinkedList<>();
    // 왼쪽, 오른쪽, 위, 아래
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];

                if (map[i][j] == 'o') coinList.add(new Coin(j, i));
            }
        }

        bfs();

        System.out.println(INF == res? "-1" : res);
    }

    public static void bfs() {
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[coinList.get(0).y][coinList.get(0).x][coinList.get(1).y][coinList.get(1).x] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(new Coin(coinList.get(0).x, coinList.get(0).y), new Coin(coinList.get(1).x, coinList.get(1).y), 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curCnt = cur.cnt;

            if(curCnt >= 10) break;

            for(int i=0; i<4; i++){
                int flag = 0;

                Coin coin1 = cur.coin1;
                Coin coin2 = cur.coin2;

                int nx1 = coin1.x;
                int ny1 = coin1.y;
                int nx2 = coin2.x;
                int ny2 = coin2.y;

                if(checkMapArea(nx1 + dx[i], ny1 + dy[i])) {
                    if (map[ny1 + dy[i]][nx1 + dx[i]] != '#') {
                        nx1 += dx[i];
                        ny1 += dy[i];
                    }
                }
                else {
                    flag += 1;
                }

                if(checkMapArea(nx2 + dx[i], ny2 + dy[i])) {
                    if (map[ny2 + dy[i]][nx2 + dx[i]] != '#') {
                        nx2 += dx[i];
                        ny2 += dy[i];
                    }
                }
                else {
                    flag += 1;
                }

                // 둘다 종료했으면 패스
                if(flag == 2) continue;

                // 종료 확인
                if(flag == 1) {
                    res = Math.min(curCnt + 1, res);
                    return;
                }

                // 방문 여부 확인
                if(curCnt + 1 < 10) {
                    if (!visited[ny1][nx1][ny2][nx2]) {
                        visited[ny1][nx1][ny2][nx2] = true;
                        q.add(new Node(new Coin(nx1, ny1), new Coin(nx2, ny2), curCnt + 1));
                    }
                }
            }
        }
    }

    public static boolean checkMapArea(int x, int y){
        return x>=0 && y>=0 && x < M && y < N;
    }
    static class Node {
        Coin coin1, coin2;
        int cnt;

        Node(Coin coin1, Coin coin2, int cnt){
            this.coin1 = coin1;
            this.coin2 = coin2;
            this.cnt = cnt;
        }
    }

    static class Coin {
        int x, y;

        Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
