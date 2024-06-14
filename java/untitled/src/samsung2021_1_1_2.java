import java.util.*;
import java.io.*;

// 색깔 폭탄
public class samsung2021_1_1_2 {
    static int N, M;
    // 동, 남, 서, 북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int RED = 0;
    static int BLACK = -1;
    static int BLANK = -2;
    // 살아있는 폭탄 개수
    static int bombCnt = 0;
    static int score = 0;

    static int[][] bombMap;

    static LinkedList<Bombs> list;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        bombMap = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                bombMap[i][j] = stoi(st.nextToken());

                if(bombMap[i][j] != BLACK) bombCnt += 1;
            }
        }

        while(bombCnt != 0) {
            // 1. 폭탄 찾기
            Bombs bombs = getBomb();

            if(bombs.cnt == 1) break;
            // 2. 폭탄 제거 후 score 추가
            addScore(bombs);

            // 3. 중력 작
            move();

            // 4. 반시계 방향으로 90도 회전
            rotate();

            // 5. 중력 작용
            move();
        }

        System.out.println(score);
    }

    public static void move() {
        // x
        for(int x=0; x<N; x++) {
            // y
            for(int y=N-2; y>=0; y--) {

                // 돌, 공백 pass
                if(bombMap[y][x] == BLACK) continue;

                if(bombMap[y][x] == BLANK) continue;

                int ny = y;

                boolean flag = false;
                while(++ny != N) {
                    if(bombMap[ny][x] == BLANK) {
                        flag = true;
                    }else {
                        break;
                    }
                }
                ny -= 1;

                if(!flag) continue;

                bombMap[ny][x] = bombMap[y][x];
                bombMap[y][x] = BLANK;
            }
        }
    }

    public static void rotate() {
        int[][] tempMap = new int[N][N];

        // TODO: 정리하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                tempMap[N - j - 1][i] = bombMap[i][j];
            }
        }
        bombMap = tempMap;
    }

    public static void addScore(Bombs bombs) {
        for(Point p : bombs.list) {
            bombMap[p.y][p.x] = BLANK;
            bombCnt -= 1;
        }

        score += bombs.cnt * bombs.cnt;
    }

    public static Bombs getBomb() {
        list = new LinkedList<>();
        checked = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(checked[i][j]) continue;

                if(bombMap[i][j] == BLACK) continue;
                if(bombMap[i][j] == BLANK) continue;
                // 레드는 건너 뜀 (어차피 레드는 무조건 포함되서 사라짐)
                if(bombMap[i][j] == RED) continue;

                Bombs result = search(bombMap[i][j], j, i);

                if(list.isEmpty()) list.add(result);
                else {
                    if(list.get(0).cnt < result.cnt) list = new LinkedList<>();

                    list.add(result);
                }

            }
        }

        Collections.sort(list);

        return list.get(0);
    }

    public static Bombs search(int idx, int x, int y)  {
        Bombs bombs = new Bombs(x, y);
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        bombs.add(idx, x, y);
        visited[y][x] = true;
        checked[y][x] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isInrange(nx, ny)) continue;

                if(bombMap[ny][nx] == BLANK) continue;
                if(bombMap[ny][nx] == BLACK) continue;
                // 1. 현재 색이랑 같지 않고, 빨간색도 아니면 pass
                if(bombMap[ny][nx] != idx && bombMap[ny][nx] != RED) continue;

                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;

                bombs.add(bombMap[ny][nx], nx, ny);
                queue.add(new Point(nx, ny));

                // red는 겹칠 수 있음
                if(bombMap[ny][nx] != RED) checked[ny][nx] = true;
            }
        }

        return bombs;
    }

    public static class Bombs implements Comparable<Bombs>{
        LinkedList<Point> list = new LinkedList<>();
        int mx, my, yLen = 1;
        int cnt = 0;
        int redCnt = 0;

        Bombs(int x, int y) {
            this.mx = x;
            this.my = y;
        }

        void add(int idx, int x, int y){
            this.list.add(new Point(x, y));
            this.cnt += 1;

            if(idx == RED) {
                this.redCnt += 1;
            }
            else {
                // yLen변경
                if(this.my < y) {
                    this.yLen = 1;
                }
                else if(this.my == y) {
                    this.yLen += 1;
                }
                this.mx = Math.min(this.mx, x);
                this.my = Math.max(this.my, y);
            }
        }

        @Override
        public int compareTo(Bombs b) {
            // 크기부터
            if(this.cnt != b.cnt) return b.cnt - this.cnt;

            // 2.1 빨간색 폭탄 개수가 가장 작은 것
            if(this.redCnt != b.redCnt) return this.redCnt - b.redCnt;

            // 2.2 빨간색 아닌 y좌표가 가장 큰 칸
            if(this.my != b.my) return b.my - this.my;

            // 2.3 빨간색 아닌 x좌표가 가장 작은 칸
            if(this.mx != b.mx) return this.mx - b.mx;

            // 2.4 빨간색 아닌 색중에 열 개수 작은 폭탄
            return this.yLen - b.yLen;
        }
    }

    public static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isInrange(int x, int y) {
        return x>= 0 && y>= 0 && x < N && y < N;
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
