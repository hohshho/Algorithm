package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num5427 {
    static int N, w, h, result;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static Queue<Position> personQueue;
    static Queue<Position> fireQueue;
    static String map[][], res[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        res = new String[N];

        for (int i = 0; i < N; i++) {
            String[] wh = br.readLine().split(" ");
            w = stoi(wh[0]);
            h = stoi(wh[1]);

            // h : 행 / w : 열
            map = new String[h][w];
            personQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String[] input = br.readLine().split("");
                for (int k = 0; k < w; k++) {
                    if (input[k].equals("@")) {
                        personQueue.add(new Position(j, k));
                    } else if (input[k].equals("*")) {
                        fireQueue.add(new Position(j, k));
                    }

                    map[j][k] = input[k];
                }
            }

            result = 0;
            bfs();

            res[i] = result == 0 ? "IMPOSSIBLE" : Integer.toString(result);
        }

        for (String item : res) {
            System.out.println(item);
        }

    }

    public static void bfs() {
        int cnt = 0;

        while (!personQueue.isEmpty()) {
            // 1. 먼저 불 전파
            int fSize = fireQueue.size();

            // 현재 q에 들어있는 것들 전파
            for (int i = 0; i < fSize; i++) {
                Position cur = fireQueue.poll();

                for(int j=0; j<4; j++){
                    int cx = cur.x + dx[j];
                    int cy = cur.y + dy[j];

                    if(checkValue(cx, cy)) {
                        if(map[cx][cy].equals("@") || map[cx][cy].equals(".")) {
                            map[cx][cy] = ("*");
                            fireQueue.add(new Position(cx, cy));
                        }
                    }
                }
            }

            // 2. 사람 이동
            int pSize = personQueue.size();

            for(int i=0; i<pSize; i++){
                Position cur = personQueue.poll();

                for(int j=0; j<4; j++){
                    int cx = cur.x + dx[j];
                    int cy = cur.y + dy[j];

                    if(!checkValue(cx, cy)) {
                        result = cnt + 1;
                        return;
                    }

                    if(checkValue(cx, cy)) {
                        if(map[cx][cy].equals(".")) {
                            map[cx][cy] = ("@");
                            personQueue.add(new Position(cx, cy));
                        }
                    }
                }
            }
            cnt++;
        }
    }


    static boolean checkValue(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }

    public static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
