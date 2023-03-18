package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class num20056 {
    static int N, M, K, res = 0;
    static LinkedList<Integer>[][] map;
    // 현재 활동하는 Fire index
    static HashSet<Integer> liveFires = new HashSet<>();
    // 현재 활동하는 Fire에 상세 정보
    static HashMap<Integer, Fire> fireHashMap = new HashMap<>();
    //
    static int fireCnt = 0;
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMK = br.readLine().split(" ");

        N = stoi(NMK[0]);
        M = stoi(NMK[1]);
        K = stoi(NMK[2]);

        map = new LinkedList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for (int i = 1; i <= M; i++) {
            String[] input = br.readLine().split(" ");

            int y = stoi(input[0]) - 1;
            int x = stoi(input[1]) - 1;
            int weight = stoi(input[2]);
            int speed = stoi(input[3]);
            int direction = stoi(input[4]);

            liveFires.add(i);
            fireHashMap.put(i, new Fire(x, y, direction, speed, weight));
            map[y][x].add(i);
            fireCnt = i;
        }

        for (int i = 0; i < K; i++) {
            // 이동
            for (int fireIdx : liveFires) {
                Fire fire = fireHashMap.get(fireIdx);

                // 맵에서 기존 fire 삭제
                map[fire.y][fire.x].removeFirst();

                // 다음 위치 탐색
                fire.getNextPosition();
                map[fire.y][fire.x].add(fireIdx);
            }

            // 2번 처리
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[k][j].size() < 2) continue;

                    // 1. 하나로 합치면서 질량, 속력, 방향 계산 / 기존 불 전부 삭제(liveFires, fireHashMap)
                    int x = j, y = k;
                    int sum_weight = 0;
                    int sum_speed = 0;
                    int first_reminder = -1;
                    boolean sameRemider = true;
                    int curSize = map[k][j].size();

                    LinkedList<Integer> fires = map[k][j];

                    for (int curIndex : fires) {
                        Fire cur = fireHashMap.get(curIndex);

                        if (first_reminder == -1) {
                            first_reminder = cur.direction % 2;
                        } else {
                            int cur_reminder = cur.direction % 2;

                            if (cur_reminder != first_reminder) sameRemider = false;
                        }

                        sum_speed += cur.speed;
                        sum_weight += cur.weight;

                        liveFires.remove(curIndex);
                        fireHashMap.remove(curIndex);
                    }

                    map[y][x] = new LinkedList<>();

                    // 질량 0이면 pass(삭제만)
                    if (sum_weight / 5 == 0) continue;

                    // 2. 불 생성해 추가(liveFires, fireHashMap)
                    int addFireDirection = sameRemider ? 0 : 1;
                    for (int z = 0; z < 4; z++) {
                       fireCnt += 1;
                       map[y][x].add(fireCnt);
                       liveFires.add(fireCnt);
                       fireHashMap.put(fireCnt, new Fire(x, y, addFireDirection, sum_speed / curSize, sum_weight / 5));
                       addFireDirection += 2;
                    }

                }
            }


        }

        for (int fireIdx : liveFires) {
            res += fireHashMap.get(fireIdx).weight;
        }

        System.out.println(res);
    }

    static boolean checkArea(int X, int Y) {
        return X >= 0 && Y >= 0 && X < N && Y < N;
    }

    static class Fire {
        int x, y, direction, speed, weight;

        Fire(int x, int y, int direction, int speed, int weight) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.speed = speed;
            this.weight = weight;
        }

        void getNextPosition() {
            int move = this.speed % N;
            // x, direction, y 수정 필요
            this.x = (N + this.x + (dx[direction] * (this.speed % N))) % N;
            this.y = (N + this.y + (dy[direction] * (this.speed % N))) % N;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
