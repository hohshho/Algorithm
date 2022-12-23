package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num14499 {
    static int N, M, x, y, K, map[][], commands[];
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = stoi(input[0]);
        M = stoi(input[1]);
        x = stoi(input[2]);
        y = stoi(input[3]);
        K = stoi(input[4]);
        map = new int[N][M];
        commands = new int[K];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(input[j]);
            }
        }

        input = br.readLine().split(" ");

        Dice dice = new Dice(x, y);

        for(int i = 0; i < K; i++) {
            commands[i] = stoi(input[i]) - 1;

            int res = dice.run(commands[i]);

            if(res == -1) {
                continue;
            }

            results.add(res);
        }

        for(int result : results) {
            System.out.println(result);
        }
    }

    static class Dice {
        // 동, 서, 북, 남
        int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};

        int x, y; // 현재 좌표
        int top, left, right, up, down, bottom;

        Dice(int x, int y) {
            this.x = x;
            this.y = y;
            top = 0;
        }

        // TODO: 상수 사용해서 해보자
        public int run(int command) {
            int nx = this.x + dx[command];
            int ny = this.y + dy[command];

            // 맵 범위에 벗어나면 명령 무시
            if(!checkMapPoint(nx, ny)) {
                return -1;
            }
            x = nx;
            y = ny;
            // 동
            if(command == 0) {
                // 주사위 이동
                int tmp = left;
                left = bottom;
                bottom = right;
                right = top;
                top = tmp;
            }
            // 서
            else if(command == 1){
                int tmp = right;
                right = bottom;
                bottom = left;
                left = top;
                top = tmp;
            }
            // 북
            else if(command == 2) {
                int tmp = up;
                up = top;
                top = down;
                down = bottom;
                bottom = tmp;
            }
            // 남
            else if(command == 3) {
                int tmp = down;
                down = top;
                top = up;
                up = bottom;
                bottom = tmp;
            }

            // 주사위 처리
            if(map[nx][ny] != 0) {
                bottom = map[nx][ny];
                map[nx][ny] = 0;
            } else {
                map[nx][ny] = bottom;
            }

            return top;
        }

        public boolean checkMapPoint(int x, int y){
            return x >= 0 && y >= 0 && y < M && x < N;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
