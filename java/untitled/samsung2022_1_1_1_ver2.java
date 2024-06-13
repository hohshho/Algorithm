import java.util.*;
import java.io.*;

// 술래잡기
public class samsung2022_1_1_1_ver2 {
    static int N, M, H, K;
    // 오른쪽, 아래, 왼쪽, 위
    static final int[] DX = new int[] {1, 0, -1, 0};
    static final int[] DY = new int[] {0, 1, 0, -1};
    // map에 나무만 저장
    static boolean[][] treeMap;
    static HashSet<Integer>[][] runnerMap;
    static HashMap<Integer, Runner> runnerList = new HashMap<Integer, Runner>();
    static Sol sol;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        H = stoi(st.nextToken());
        K = stoi(st.nextToken());

        treeMap = new boolean[N][N];
        runnerMap = new HashSet[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                runnerMap[i][j] = new HashSet<>();
            }
        }

        int rIdx = 1;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = stoi(st.nextToken()) - 1;
            int x = stoi(st.nextToken()) - 1;
            // 1: 우, 2: 아래
            int dIdx = stoi(st.nextToken()) - 1;

            runnerList.put(rIdx, new Runner(rIdx, x, y, dIdx));
            runnerMap[y][x].add(rIdx++);
        }

        while(H-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = stoi(st.nextToken()) - 1;
            int x = stoi(st.nextToken()) - 1;

            treeMap[y][x] = true;
        }

        sol = new Sol(N/2, N/2);
        runnerMap[N/2][N/2].add(-1);

        while(K-- > 0) {

            // 1. 도망자 움직임
            for(int key : runnerList.keySet()) {
                Runner curRunner = runnerList.get(key);
                curRunner.move();
            }

            sol.turn += 1;

            // 2. 술래 움직임
            sol.move();

            // 3. 술래가 도망자 잡기
            sol.getScore();
            // 도망자 모두 잡았으면 끝
            if(runnerList.size() == 0) break;
        }

        System.out.println(sol.score);
    }

    static class Runner {
        int idx, x, y;
        boolean live = true;
        Direction direction;

        Runner(int idx, int x, int y, int dIdx){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.direction = Direction.getDirection(dIdx);
        }

        public void move() {
            if(!this.live) return;

            // 술래 거리 3초과이면 pass
            if(!checkRange(this.x, this.y, sol.x, sol.y)) return;

            int tempX = this.x + this.direction.getDx();
            int tempY = this.y + this.direction.getDy();

            if(!checkMap(tempX, tempY)) {
                this.direction = this.direction.getBackDirection();

                tempX = this.x + this.direction.getDx();
                tempY = this.y + this.direction.getDy();
            }

            // 술래와 위치 같은 곳은 이동 못함
            if(sol.x == tempX && sol.y == tempY) return;

            runnerMap[this.y][this.x].remove(this.idx);
            this.x = tempX;
            this.y = tempY;
            runnerMap[this.y][this.x].add(this.idx);
        }

        public void die() {
            this.live = false;
        }
    }

    static class Sol {
        int score, x, y;
        Direction direction;
        int level; // 술래가 앞으로 가야 할 횟수
        int cnt; // 술래가 앞으로 간 횟수
        int directionCnt;
        int turn;
        boolean reverse;

        Sol(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void move() {
            // 달팽이 전환
            if(this.x == 0 && this.y == 0) {
                this.level = N - 1;
                this.cnt = 0;
                this.directionCnt = -1;
                this.reverse = true;
                this.direction = Direction.SOUTH;
            }
            // 달팽이 시작
            if(this.x == N/2 && this.y == N/2) {
                this.level = 1;
                this.cnt = 0;
                this.directionCnt = 0;
                this.reverse = false;
                this.direction = Direction.NORTH;
            }

            runnerMap[this.y][this.x].remove(-1);
            this.x = this.x + this.direction.getDx();
            this.y = this.y + this.direction.getDy();
            runnerMap[this.y][this.x].add(-1);

            this.cnt += 1;

            // 방향 전환 필요한지 체크
            if(this.cnt != this.level) return;

            this.cnt = 0;
            // 방향 전환
            this.direction = !reverse ? this.direction.getNextDirection() : this.direction.getReverseNextDirection();

            // 2번 체크
            this.directionCnt += 1;
            if(this.directionCnt != 2) return;

            // 횟수 + 1
            this.level += !reverse ? 1 : -1;
            this.directionCnt = 0;
        }

        public void getScore() {

            int catchCnt = 0;

            for(int i=0; i<=2; i++) {
                int tempX = this.x + this.direction.getDx() * i;
                int tempY = this.y + this.direction.getDy() * i;

                if(!checkMap(tempX, tempY)) break;
                // tree가 있는 경우 pass
                if(treeMap[tempY][tempX]) continue;

                // runner가 없는 경우 pass
                if(runnerMap[tempY][tempX].size() == 0) continue;

                LinkedList<Integer> removeList = new LinkedList<>();
                for(int idx : runnerMap[tempY][tempX]) {
                    if(idx == -1) continue;
                    removeList.add(idx);
                    catchCnt += 1;
                }
                for(int idx : removeList) {
                    if(idx == -1) continue;
                    runnerMap[tempY][tempX].remove(idx);
                    runnerList.get(idx).die();
                }
            }

            if(catchCnt != 0) this.score += (this.turn * catchCnt);
        }

    }

    static enum Direction {
        EAST(0),
        SOUTH(1),
        WEST(2),
        NORTH(3);

        private final int idx;
        private final int dx;
        private final int dy;


        Direction(int idx){
            this.idx = idx;
            this.dx = DX[idx];
            this.dy = DY[idx];
        }

        public int getIdx() {
            return this.idx;
        }

        public int getDx() {
            return this.dx;
        }

        public int getDy() {
            return this.dy;
        }

        public static Direction getDirection(int idx) {
            return Direction.values()[idx];
        }

        public Direction getBackDirection() {
            int nextIdx = (this.idx + 2) % 4;
            return Direction.values()[nextIdx];
        }

        public Direction getNextDirection() {
            int nextIdx = (this.idx + 1) % 4;
            return Direction.values()[nextIdx];
        }

        public Direction getReverseNextDirection() {
            int nextIdx = (this.idx - 1 + 4) % 4;
            return Direction.values()[nextIdx];
        }
    }

    public static boolean checkMap(int x, int y) {
        return x >= 0 && x < N && y < N && y >= 0;
    }

    public static boolean checkRange(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2)) <= 3;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
