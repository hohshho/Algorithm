import java.util.*;
import java.io.*;


public class 안전운전을도와줄차세대지능형교통시스템 {
    // 동 남 서 북
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static LinkedList<Traffic> traffics = new LinkedList<>();
    static LinkedList<Traffic>[][] map;
    static boolean[][] visited;
    // x, y, time, direction
    static boolean[][][][] check;
    static int N, T, res;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeTraffics();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        T = stoi(st.nextToken());

        map = new LinkedList[N][N];
        visited = new boolean[N][N];
        check = new boolean[N][N][4][4];


        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int y = i / N;
            int x = i % N;
            map[y][x] = new LinkedList<Traffic>();

            for (int j = 0; j < 4; j++) {
                int trafficIndex = stoi(st.nextToken()) - 1;
                map[y][x].add(traffics.get(trafficIndex));
            }
        }

        run(3, 0, 0, 0);

        System.out.println(res);
    }

    // direction, x, y, time
    public static void run(int direction, int x, int y, int time) {
        Car car = new Car(direction, x, y, time);
        check[0][0][time][direction] = true;
        visited[0][0] = true;
        res += 1;
        Queue<Car> queue = new LinkedList<>();
        queue.add(car);

        while (!queue.isEmpty()) {
            Car cur = queue.poll();
            int curX = cur.x, curY = cur.y, curDirection = cur.direction, curTime = cur.time;

            // 현재 교차로 정보 가져오기
            LinkedList<Traffic> curTrafficList = map[curY][curX];

            // 현재 신호 정보 가져오기
            Traffic curTraffic = curTrafficList.get(curTime % 4);

            if (curDirection != curTraffic.predirection) continue;

            for (int j = 0; j < curTraffic.nextDirections.length; j++) {
                int nextDirection = curTraffic.nextDirections[j];
                int ny = curY + dy[nextDirection];
                int nx = curX + dx[nextDirection];

                // 다음 좌표 사용 불가능하면 pass
                if (!checkPoint(nx, ny)) continue;

                if (check[ny][nx][(curTime + 1) % 4][nextDirection]) continue;

                if (curTime + 1 > T) break;

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    res += 1;
                }

                check[ny][nx][(curTime + 1) % 4][nextDirection] = true;
                queue.add(new Car(nextDirection, nx, ny, curTime + 1));
            }
        }
    }

    public static boolean checkPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void makeTraffics() {
        // 동: 0, 남: 1, 서:2, 북:3
        // pre, next
        // 보고 있는 방향
        traffics.add(new Traffic(0, new int[]{3, 0, 1}));
        traffics.add(new Traffic(3, new int[]{2, 3, 0}));
        traffics.add(new Traffic(2, new int[]{3, 2, 1}));
        traffics.add(new Traffic(1, new int[]{2, 1, 0}));

        traffics.add(new Traffic(0, new int[]{3, 0}));
        traffics.add(new Traffic(3, new int[]{2, 3}));
        traffics.add(new Traffic(2, new int[]{2, 1}));
        traffics.add(new Traffic(1, new int[]{1, 0}));

        traffics.add(new Traffic(0, new int[]{0, 1}));
        traffics.add(new Traffic(3, new int[]{3, 0}));
        traffics.add(new Traffic(2, new int[]{3, 2}));
        traffics.add(new Traffic(1, new int[]{2, 1}));
    }

    static class Car {
        int direction, x, y, time;

        Car(int direction, int x, int y, int time) {
            this.direction = direction;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static class Traffic {
        int predirection;
        int[] nextDirections;

        Traffic(int predirection, int[] nextDirections) {
            this.predirection = predirection;
            this.nextDirections = nextDirections;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
