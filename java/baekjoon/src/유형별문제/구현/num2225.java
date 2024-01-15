package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2225 {
    static int N, K, M, res;
    static int[][] map;
    // 0 : 남, 1 : 서, 2 : 북, 3 : 동,
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static Dice dice = new Dice();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // y축
        M = stoi(st.nextToken()); // x축
        K = stoi(st.nextToken()); // 주사위 굴리는 횟수

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            if(i!=0) {
                if (map[dice.y][dice.x] < dice.bottom) dice.rotate(1);
                else if (map[dice.y][dice.x] > dice.bottom) dice.rotate(2);
            }

            dice.run();
        }

        System.out.println(res);
    }

    public static class Dice {
        int direction;
        int north, south, east, west, bottom, top;
        int x, y;

        // 시계방향 : 1, 시계 반대방향 2
        void rotate(int flag) {
            if (flag == 1) {
                this.direction += 1;
            } else if (flag == 2) {
                this.direction -= 1;
            }

            if (this.direction == -1) this.direction = 3;
            if (this.direction == 4) this.direction = 0;
        }

        void run() {
            // 방향 확인
            if(!checkMapArea(this.x + dx[this.direction], this.y + dy[this.direction])) {
                this.direction = (this.direction + 2) % 4;
            }

            // 이동
            this.x += dx[this.direction];
            this.y += dy[this.direction];

            if (this.direction == 3) { // 동
                int temp = this.top;
                this.top = this.west;
                this.west = this.bottom;
                this.bottom = this.east;
                this.east = temp;
            } else if (this.direction == 1) { // 서
                int temp = this.top;
                this.top = this.east;
                this.east = this.bottom;
                this.bottom = this.west;
                this.west = temp;
            } else if (this.direction == 0) { // 남
                int temp = this.top;
                this.top = this.north;
                this.north = this.bottom;
                this.bottom = this.south;
                this.south = temp;
            } else if (this.direction == 2) { // 북
                int temp = this.top;
                this.top = this.south;
                this.south = this.bottom;
                this.bottom = this.north;
                this.north = temp;
            }

            // 갈 수 있는 곳 확인 (지도 상 동일한 곳이 있으면 점수에 포함)
            res += getScore(this.x, this.y);
        }

        Dice() {
            // init
            this.direction = 3;
            this.x = 0;
            this.y = 0;

            this.top = 1;
            this.north = 2;
            this.south = 5;
            this.east = 3;
            this.west = 4;
            this.bottom = 6;
        }
    }

    public static int getScore(int x, int y){
        int total = 0;

        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[y][x] = true;
        int curValue = map[y][x];
        total += curValue;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = dx[i] + cur.x, ny = dy[i] + cur.y;

                if(!checkMapArea(nx, ny)) continue;

                if(visited[ny][nx]) continue;

                if(map[ny][nx] != curValue) continue;

                total += curValue;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }

        return total;
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkMapArea(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}