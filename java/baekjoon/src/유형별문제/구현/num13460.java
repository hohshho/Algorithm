package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num13460 {
    static int N, M, res = -1, holeX, holeY;
    static char[][] map;
    static boolean[][][][] visited;
    // 상, 우, 하, 좌
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static Bead red, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);
        map = new char[N][M];

        char[][] input = new char[N][M];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = input[i][j];

                if (map[i][j] == 'B') {
                    blue = new Bead(i, j, 0);
                }

                if (map[i][j] == 'R') {
                    red = new Bead(i, j, 0);
                }

                if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }

        search();

        System.out.println(res);
    }

    public static void search() {
        Queue<Bead> redQueue = new LinkedList<>();
        Queue<Bead> blueQueue = new LinkedList<>();
        visited = new boolean[N][M][N][M];
        redQueue.add(new Bead(red.x, red.y, red.cnt));
        blueQueue.add(new Bead(blue.x, blue.y, blue.cnt));


        while (!redQueue.isEmpty()) {
            Bead red = redQueue.poll();
            Bead blue = blueQueue.poll();

            if (red.cnt > 9) {
                return;
            }

            // 방문 체크
            if (visited[red.x][red.y][blue.x][blue.y]) continue;

            visited[red.x][red.y][blue.x][blue.y] = true;

            for (int i = 0; i < 4; i++) {
                Bead nextRed = new Bead(red.x, red.y, red.cnt + 1);
                Bead nextBlue = new Bead(blue.x, blue.y, blue.cnt + 1);

                boolean redFlag = false;
                while (map[nextRed.x + dx[i]][nextRed.y + dy[i]] != '#') {
                    nextRed.x += dx[i];
                    nextRed.y += dy[i];
                    if (nextRed.x == holeX && nextRed.y == holeY) {
                        redFlag = true;
                        break;
                    }
                }

                boolean blueFlag = false;
                while (map[nextBlue.x + dx[i]][nextBlue.y + dy[i]] != '#') {
                    nextBlue.x += dx[i];
                    nextBlue.y += dy[i];
                    if (nextBlue.x == holeX && nextBlue.y == holeY) {
                        blueFlag = true;
                        break;
                    }
                }

                if (blueFlag) {
                    continue;
                }

                if (redFlag && !blueFlag) {
                    res = nextRed.cnt;
                    return;
                }

                if(nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
                    // 상
                    if(i == 0) {
                        if(red.x > blue.x) nextRed.x -= dx[i];
                        else nextBlue.x -= dx[i];
                    }
                    // 우
                    else if(i == 1) {
                        if(red.y < blue.y) nextRed.y -= dy[i];
                        else nextBlue.y -= dy[i];
                    }
                    // 하
                    else if(i == 2) {
                        if(red.x < blue.x) nextRed.x -= dx[i];
                        else nextBlue.x -= dx[i];
                    }
                    // 좌
                    else {
                        if(red.y > blue.y) nextRed.y -= dy[i];
                        else nextBlue.y -= dy[i];
                    }
                }

                if (!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                    redQueue.add(new Bead(nextRed.x, nextRed.y, nextRed.cnt));
                    blueQueue.add(new Bead(nextBlue.x, nextBlue.y, nextBlue.cnt));
                }
            }
        }
    }

    static class Bead {
        int x, y, cnt;

        Bead(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
