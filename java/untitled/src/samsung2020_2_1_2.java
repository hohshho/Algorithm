import java.util.*;
import java.io.*;

// FIXME: 일단 이거 안됌 테케 10에서 걸리는데 다시 풀어보고 고쳐보자
// 2시간 ++
// 00:10분
// 원자충돌
public class samsung2020_2_1_2 {
    static Simulation simulation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        simulation = new Simulation(stoi(st.nextToken()));

        // m, k
        int m = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = stoi(st.nextToken()) - 1;
            int x = stoi(st.nextToken()) - 1;
            int w = stoi(st.nextToken());
            int s = stoi(st.nextToken());
            int d = stoi(st.nextToken());

            simulation.addNode(x, y, w, s, d);
        }

        while (k-- > 0) {
            simulation.run();
        }

        int sum = 0;
        for (int i = 0; i < simulation.N; i++) {
            for (int j = 0; j < simulation.N; j++) {
                if (simulation.maps[i][j].isEmpty()) continue;

                for (Node node : simulation.maps[i][j]) {
                    sum += node.weight;
                }
            }
        }
        System.out.println(sum);
    }

    static class Simulation {
        int N;
        ArrayList<Node>[][] maps;
        ArrayList<Node>[][] tempMaps;

        Simulation(int n) {
            this.N = n;
            this.init("maps");
        }

        public void run() {
            // 0. temp 배열 초기화
            this.init("tempMaps");

            // 1. 원자 이동 / temp배열에 새로운 원자로 추가
            move();

            this.init("maps");

            // 2. 같은 원자 있으면 탐색 후 쪼개기
            add();
        }

        public void add() {
            // y
            for (int i = 0; i < this.N; i++) {
                // x
                for (int j = 0; j < this.N; j++) {
                    if (tempMaps[i][j].isEmpty()) continue;
                        // 단순 복사
                    else if (tempMaps[i][j].size() == 1) {
                        Node node = tempMaps[i][j].get(0);
                        maps[i][j].add(new Node(node.weight, node.speed, node.direction.getIdx()));
                    } else {
                        int weightSum = 0;
                        int flag = 0;
                        int speedSum = 0;
                        int cnt = 0;

                        for (Node node : tempMaps[i][j]) {
                            cnt += 1;
                            weightSum += node.weight;
                            speedSum += node.speed;
                            if (node.direction.getIdx() % 2 == 1) flag = 1;
                        }

                        // 질량이 0이면 소멸
                        if (Math.floor(weightSum / 5) <= 0) continue;

                        // k 는 다음 방향
                        for (int k = 0 + flag; k < 8; k += 2) {
                            maps[i][j].add(new Node((int) Math.floor(weightSum / 5), (int) Math.floor(speedSum / cnt), k));
                        }
                    }
                }
            }
        }

        public void move() {
            // y
            for (int i = 0; i < this.N; i++) {
                // x
                for (int j = 0; j < this.N; j++) {
                    if (maps[i][j].isEmpty()) continue;

                    for (Node node : maps[i][j]) {
                        Point nextPoint = node.getNextPoint(new Point(node.direction.getIdx(), j, i), N);

                        tempMaps[nextPoint.y][nextPoint.x].add(new Node(node.weight, node.speed, node.direction.getIdx()));
                    }
                }
            }
        }

        public void init(String action) {
            if (action.equals("maps")) {
                this.maps = new ArrayList[this.N][this.N];
                for (int i = 0; i < this.N; i++) {
                    for (int j = 0; j < this.N; j++) {
                        this.maps[j][i] = new ArrayList<>();
                    }
                }
            } else if (action.equals("tempMaps")) {
                this.tempMaps = new ArrayList[this.N][this.N];
                for (int i = 0; i < this.N; i++) {
                    for (int j = 0; j < this.N; j++) {
                        this.tempMaps[j][i] = new ArrayList<>();
                    }
                }
            }
        }

        public void addNode(int x, int y, int w, int s, int d) {
            maps[y][x].add(new Node(w, s, d));
        }

    }

    static class Node {
        int weight, speed;
        Direction direction;

        Node(int w, int s, int d) {
            this.weight = w;
            this.speed = s;
            this.direction = Direction.getDirection(d);
        }

        Point getNextPoint(Point p, int n) {
            int x = (p.x + this.direction.getDelta().x * this.speed + n * this.speed) % n;
            int y = (p.y + this.direction.getDelta().y * this.speed + n * this.speed) % n;

            return new Point(p.idx, x, y);
        }
    }

    public static class Point {
        int idx, x, y;

        Point(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    public enum Direction {
        // idx, x, y 변화량
        // 북, 북동, 동, 동남, 남, 남서, 서, 서북
        NORTH(new Point(0, 0, -1)),
        NORTH_EAST(new Point(1, 1, -1)),
        EAST(new Point(2, 1, 0)),
        EAST_SOUTH(new Point(3, 1, 1)),
        SOUTH(new Point(4, 0, 1)),
        SOUTH_WEST(new Point(5, -1, 1)),
        WEST(new Point(6, -1, 0)),
        WEST_NORTH(new Point(7, -1, -1));

        private final Point delta;

        Direction(Point delta) {
            this.delta = delta;
        }

        public Point getDelta() {
            return this.delta;
        }

        public int getX() {
            return this.delta.x;
        }

        public int getY() {
            return this.delta.y;
        }

        public int getIdx() {
            return this.delta.idx;
        }

        public static Direction getDirection(int number) {
            if (number == 0) return NORTH;
            else if (number == 1) return NORTH_EAST;
            else if (number == 2) return EAST;
            else if (number == 3) return EAST_SOUTH;
            else if (number == 4) return SOUTH;
            else if (number == 5) return SOUTH_WEST;
            else if (number == 6) return WEST;
            else if (number == 7) return WEST_NORTH;
            else throw new IllegalArgumentException("error");
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
