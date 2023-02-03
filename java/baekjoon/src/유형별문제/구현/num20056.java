package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class num20056 {
    static int N, M, K, res = 0;
    static LinkedList<Integer>[][] map;
    static HashMap<Integer, Fire> fireHashMap = new HashMap<>();
    static HashSet<Integer> liveFires = new HashSet<>();
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMK = br.readLine().split(" ");

        N = stoi(NMK[0]);
        M = stoi(NMK[1]);
        K = stoi(NMK[2]);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for (int i = 1; i <= M; i++) {
            String[] input = br.readLine().split(" ");

            int x = stoi(input[0]) - 1;
            int y = stoi(input[1]) - 1;
            int weight = stoi(input[2]);
            int direction = stoi(input[3]);
            int speed = stoi(input[4]);

            fireHashMap.put(i, new Fire(y, y, direction, speed, weight));
            liveFires.add(i);
        }

        for (int i = 0; i < K; i++) {
            // 이동
            for (int fireIdx : liveFires) {
                Fire fire = fireHashMap.get(fireIdx);

//                fire.x = ;
                map[fire.y][fire.x].add(fireIdx);
            }

            // 2번 처리


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
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
