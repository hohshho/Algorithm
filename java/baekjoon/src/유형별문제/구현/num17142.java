package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num17142 {
    static int N, M, map[][], min = Integer.MAX_VALUE, originEmptyCnt = 0;
    static int[] dx = new int[]{1, -1, 0, 0}, dy = new int[]{0, 0, 1, -1};
    static boolean[][] visited;
    static ArrayList<Virus> viruses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
                if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }else if (map[i][j] == 0) {
                    originEmptyCnt++;
                }
            }
        }

        selectVirus(0, 0, new Virus[M]);

        if (originEmptyCnt == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void selectVirus(int idx, int cnt, Virus[] selected) {
        if (cnt == M) {
            searchVirus(selected, originEmptyCnt);
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            selected[cnt] = viruses.get(i);
            selectVirus(i + 1, cnt + 1, selected);
        }
    }

    static void searchVirus(Virus[] list, int emptyCnt) {
        Queue<Virus> q = new LinkedList<>();
        visited = new boolean[N][N];

        for (Virus virus : list) {
            q.add(virus);
            visited[virus.x][virus.y] = true;
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if (!checkMapArea(nx, ny)) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                if (map[nx][ny] == 0) {
                    emptyCnt--;
                }

                if (emptyCnt == 0) {
                    min = Math.min(min, cur.time + 1);
                    return;
                }

                q.add(new Virus(nx, ny, cur.time + 1));
                visited[nx][ny] = true;
            }
        }
    }

    static boolean checkMapArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Virus {
        int x, y, time;

        Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
