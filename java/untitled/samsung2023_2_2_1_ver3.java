import java.util.*;
import java.io.*;

// 3시간
// 1. 입력값 제발 좀 확인
// 2. 루돌프 rdx 잘못된 식으로 했는데 익숙한 코드라고 문제 제대로 안읽으면 안된다잉
public class samsung2023_2_2_1_ver3 {
    static int N, M, P, C, D;
    // 북, 북동, 동, 동남, 남, 서남, 서, 서북
//	static int[] rdx = {0, 1, 1, 1, 0, -1, -1, -1};
//	static int[] rdy = {-1, -1, 0, 1, 1, 1, 0, -1};
    // 좌, 하, 우, 상 (우선순위 떄문에 역으로)
    static int BLANK = -1;
    static int[] sdx = { -1, 0, 1, 0 };
    static int[] sdy = { 0, 1, 0, -1 };
    static LinkedList<Santa> santaList = new LinkedList<>();
    static int[][] map;
    static int finishSantaCnt = 0;

    static Rudolph ru;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        P = stoi(st.nextToken());
        C = stoi(st.nextToken());
        D = stoi(st.nextToken());

        // (r,c) 형태 r : y, c : x
        st = new StringTokenizer(br.readLine());
        int ry = stoi(st.nextToken()) - 1;
        int rx = stoi(st.nextToken()) - 1;
        ru = new Rudolph(rx, ry);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = -1;
            }
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = stoi(st.nextToken()) - 1;
            int y = stoi(st.nextToken()) - 1;
            int x = stoi(st.nextToken()) - 1;

            santaList.add(new Santa(idx, x, y));
            map[y][x] = idx;
        }
        Collections.sort(santaList);

        while (M-- > 0) {
            // 루돌프 움직임
            ru.move();

            for (Santa santa : santaList) {
                // 기절하거나 장외 산타 pass
                if (santa.stun > 0 || santa.finish)
                    continue;

                int curDistance = getDistance(ru.x, ru.y, santa.x, santa.y);

                boolean moveFlag = false;
                int dx = 0, dy = 0, nx = 0, ny = 0;
                // 좌, 하, 우, 상
                // 상, 우, 하, 좌 순으로 이동
                for (int i = 0; i < 4; i++) {
                    nx = santa.x + sdx[i];
                    ny = santa.y + sdy[i];

                    // 밖으로는 이동 불가, 다른 산타 있거나
                    if (!isInrange(nx, ny) || map[ny][nx] != BLANK)
                        continue;

                    // 움직이더라도 가까워지지 않으면 이동x
                    int nextDistance = getDistance(ru.x, ru.y, nx, ny);

                    if (nextDistance > curDistance)
                        continue;
                    curDistance = nextDistance;
                    moveFlag = true;
                    dx = sdx[i];
                    dy = sdy[i];
                }

                // 루돌프쪽으로 1칸 이동 4방향
                if (!moveFlag)
                    continue;

                santa.run("move", dx, dy, 1);
            }

            for (Santa santa : santaList) {
                if (santa.finish)
                    continue;
                // 매 턴 이후 산타는 +1점
                santa.addScore(1);
                // 산타 전체 돌면서 stun - 1
                if (santa.stun > 0)
                    santa.stun -= 1;
            }

            if(finishSantaCnt == P) break;
        }

        for(Santa santa : santaList) {
            System.out.print(santa.score + " ");
        }
    }

    static class Rudolph {
        int x, y;

        Rudolph(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move() {
            LinkedList<Distance> distanceList = new LinkedList<>();
            // 가까운 산타 탐색
            for (Santa santa : santaList) {
                // 장외 산타 제외
                if (santa.finish)
                    continue;

                distanceList.add(new Distance(santa.idx, santa.x, santa.y, getDistance(ru.x, ru.y, santa.x, santa.y)));
            }
            Collections.sort(distanceList);
            Distance distance = distanceList.get(0);

            Santa minSanta = santaList.get(distance.idx);

            // 해당 방향으로 이동
            int rdx = this.x > minSanta.x ? -1 : this.x == minSanta.x ? 0 : 1;
            int rdy = this.y > minSanta.y ? -1 : this.y == minSanta.y ? 0 : 1;
            this.x = this.x + rdx;
            this.y = this.y + rdy;

            // 부딪쳤을 경우 push
            if (this.x == minSanta.x && this.y == minSanta.y)
                minSanta.run("push", rdx, rdy, C);
        }
    }

    static class Distance implements Comparable<Distance> {
        int idx, x, y, distance;

        Distance(int idx, int x, int y, int distance) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance d) {
            if (this.distance != d.distance)
                return this.distance - d.distance;
            if (this.y != d.y)
                return d.y - this.y;
            return d.x - this.x;
        }
    }

    static class Santa implements Comparable<Santa>{
        int idx, x, y;
        int stun = 0;
        boolean finish = false;
        int score = 0;

        Santa(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        void run(String action, int dx, int dy, int cnt) {
            int nx = this.x + (dx * cnt);
            int ny = this.y + (dy * cnt);

            // 벗어나지 않았을 경우
            if (isInrange(nx, ny)) {
                // 푸시 / 루돌프 cnt = C, 산타 cnt = D
                if (action.equals("push")) {
                    // 상호작용
                    if (map[ny][nx] != BLANK)
                        santaList.get(map[ny][nx]).run("interaction", dx, dy, 1);
                }
                // 산타가 움직임
                else if (action.equals("move")) {
                    // XXX: move만 먼저 이동
                    // 현재 산타 좌표 갱신
                    map[this.y][this.x] = -1;

                    this.x = nx;
                    this.y = ny;

                    map[this.y][this.x] = this.idx;

                    // 루돌프 좌표 기준 push
                    if(ru.x == this.x && ru.y == this.y) this.run("push", -dx, -dy, D);
                } else if (action.equals("interaction")) {
                    if (map[ny][nx] != BLANK)
                        santaList.get(map[ny][nx]).run("interaction", dx, dy, 1);
                }
            }

            // 산타 상태 변화
            // 루돌프가 움직여서 충돌 일어난 경우 C만큼 얻고 C칸만큼 밀려남
            // 산타가 움직이면 D만큼 얻고, D만큼 밀려남
            if (action.equals("push")) {
                this.addScore(cnt);
                this.stun = 2;
            }

            // 벗어난 경우
            if (!isInrange(nx, ny)) {
                // 1. 끝난 산타 수 증가
                finishSantaCnt += 1;

                // 2. 죽은 처리
                this.finish = true;

                // 3. 기존 맵 갱신
                map[this.y][this.x] = -1;

                return;
            }

            if (!action.equals("move")) {
                // 현재 산타 좌표 갱신
                map[this.y][this.x] = -1;

                this.x = nx;
                this.y = ny;

                map[this.y][this.x] = this.idx;
            }
        }

        public void addScore(int value) {
            this.score += value;
        }

        @Override
        public int compareTo(Santa o) {
            return this.idx - o.idx;
        }
    }

    public static boolean isInrange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    // TODO: 다하고 pow도 써보자
    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
