package 유형별문제.구현;

import java.util.*;
import java.io.*;

public class num19238 {
    static int N, M;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static long energe;
    static HashMap<Integer, Person> personMap = new HashMap<>();
    static HashSet<Integer> remainList = new HashSet<>();
    static boolean[][] map;
    static Point car;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        energe = stol(st.nextToken());

        map = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                if(stoi(st.nextToken()) == 1) map[i][j] = false;
                else map[i][j] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        int cy = stoi(st.nextToken()) - 1, cx = stoi(st.nextToken()) - 1;
        car = new Point(cx, cy);

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = stoi(st.nextToken()) - 1;
            int sx = stoi(st.nextToken()) - 1;
            int ey = stoi(st.nextToken()) - 1;
            int ex = stoi(st.nextToken()) - 1;

            int distance = getDistance(sx, sy, ex, ey);

            if(distance == -1) {
                System.out.println(-1);
                return;
            }

            remainList.add(i);
            personMap.put(i, new Person(i, sx, sy, ex, ey, distance));
        }

        for(int i=0; i < M; i++) {
            // 1. 운반해야 하는 승객 번호 구하기
            int selectIndex = -1, selectX = -1, selectY = -1;
            int selectDistance = -1; // 택시부터 승객까지 거리
            for(int index : remainList) {
                Person cur = personMap.get(index);
                int curDistance = getDistance(car.x, car.y, cur.start.x, cur.start.y);

                // 도착 불가능 하면 -1
                if(curDistance == -1) {
                    System.out.println(-1);
                    return;
                }

                // 초기값
                if(selectIndex == -1) {
                    selectIndex = index;
                    selectDistance = curDistance;
                    selectX = cur.start.x;
                    selectY = cur.start.y;
                    continue;
                }

                // 거리가 짧으면 변경
                if(curDistance < selectDistance) {
                    selectIndex = index;
                    selectDistance = curDistance;
                    selectX = cur.start.x;
                    selectY = cur.start.y;
                    continue;
                }

                // 거리가 같은데 y가 더 작은 경
                if(curDistance == selectDistance && cur.start.y <= selectY) {
                    // y같으면 index 빠른 것이 우선
                    if(selectY == cur.start.y)
                        if(selectX < cur.start.x) continue;

                    selectIndex = index;
                    selectDistance = curDistance;
                    selectX = cur.start.x;
                    selectY = cur.start.y;
                }

            }

            // 1.1 운반하지 못하는 승객 생기면 종료
            if(selectIndex == -1) {
                System.out.println(-1);
                return;
            }

            Person cur = personMap.get(selectIndex);
            // 2. 남은 연로로 갈 수 있는지 확인
            long tempEnerge = energe - (selectDistance + cur.distance);

            // 2.1 남은 연로로 못 갈 경우 종료
            if(tempEnerge < 0) {
                System.out.println(-1);
                return;
            }

            // 3. 도착지로 이동 -> 택시 위치 도착지로 변경, 연료 계산, remainList삭제
            energe = tempEnerge + (cur.distance) * 2;
            car = new Point(cur.end.x, cur.end.y);
            remainList.remove(cur.index);
        }

        System.out.println(energe);
    }

    public static int getDistance(int sx, int sy, int ex, int ey) {
        // 다른 승객의 출발지와 도착지가 같을 수 있
        if(sx == ex && sy == ey) return 0;

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new Point(sx, sy, 0));
        int res = -1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = dx[i] + cur.x, ny = dy[i] + cur.y;

                // 맵 범위 초과
                if(!checkMapArea(nx, ny)) continue;

                // 벽
                if(map[ny][nx] == false) continue;

                if(visited[ny][nx]) continue;

                if(nx == ex && ny == ey) {
                    return cur.cnt + 1;
                }

                visited[ny][nx] = true;
                q.add(new Point(nx, ny, cur.cnt + 1));
            }
        }

        return res;
    }

    public static boolean checkMapArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    // index, start 지점, end지점, start -> end 거리
    public static class Person {
        int index, distance;
        Point start, end;

        Person(int index, int sx, int sy, int ex, int ey, int distance){
            this.index = index;
            this.start = new Point(sx, sy);
            this.end = new Point(ex, ey);
            this.distance = distance;
        }
    }

    public static class Point {
        int x, y, cnt;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static Long stol(String s) {
        return Long.parseLong(s);
    }
}
