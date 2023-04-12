package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num3055 {
    static int R, C, res = 0;
    static String[][] map;
    // 위, 아래, 오른쪽, 왼쪽
    static int[] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};
    static Point finish;
    static Point start;
    static LinkedList<Point> waters = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        map = new String[R][C];

        // y
        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");

            // x
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];

                if (map[i][j].equals("D")) {
                    finish = new Point(j, i);
                }

                if (map[i][j].equals("S")) {
                    start = new Point(j, i);
                    map[i][j] = ".";
                }

                if (map[i][j].equals("*")) {
                    waters.add(new Point(j, i));
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        // 초기값 설정
        q.add(new Point(start.x, start.y, 0));

        while (!q.isEmpty()) {
            // 1. 물 확장
            int wSize = waters.size();
            for (int i = 0; i < wSize; i++) {
                Point water = waters.get(i);
                int cx = water.x, cy = water.y;

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    // 1.1) map 범위 체크
                    if (!checkMapValue(nx, ny)) continue;

                    if (map[ny][nx].equals(".")) {
                        map[ny][nx] = "*";
                        waters.add(new Point(nx, ny));
                    }
                }
            }

            // 2. 고슴 도치 이동
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point curAnimal = q.poll();
                int cx = curAnimal.x, cy = curAnimal.y, cTime = curAnimal.time;

                for (int j = 0; j < 4; j++) {
                    // 2.1) 고슴 도치가 방문하지 않았고 이동 가능하면 q에 추가
                    int nx = cx + dx[j], ny = cy + dy[j];

                    // 2.1) map 범위 체크
                    if (!checkMapValue(nx, ny)) continue;

                    // 2.3) D이면 res 저장 후 종료
                    if (map[ny][nx].equals("D")) {
                        res = cTime + 1;
                        break;
                    }

                    if (map[ny][nx].equals(".")) {
                        map[ny][nx] = "S";
                        q.add(new Point(nx, ny, cTime + 1));
                    }
                }
            }

            if (res != 0) {
                break;
            }
        }

        System.out.println(res == 0 ? "KAKTUS" : res);

    }

    static class Point {
        int x, y, time;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static boolean checkMapValue(int x, int y) {
        return x >= 0 && y >= 0 && y < R && x < C;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
