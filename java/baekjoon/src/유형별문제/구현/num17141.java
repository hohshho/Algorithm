package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17141 {
    // N : 연구소 크기, M : 놓을 수 있는 바이러스 개수
    static int N, M, possibleVirusCnt, entireVirusMapCnt, INF = Integer.MAX_VALUE, res = INF;
    static int[][] initMap; // 0 : 빈 칸, 1 : 벽, 2 : 바이러스
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    static ArrayList<Virus> viruses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        initMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                initMap[i][j] = stoi(st.nextToken());

                if(initMap[i][j] == 1) initMap[i][j] = -1;
                else entireVirusMapCnt += 1;


                if (initMap[i][j] == 2) {
                    viruses.add(new Virus(j, i, 0));
                    possibleVirusCnt += 1;
                }
            }
        }

        selectVirus(0, 0, new int[M]);

        System.out.println(res == INF ? -1 : res);
    }

    public static void selectVirus(int idx, int cnt, int[] selected) {
        if (cnt == M) {
            spreadVirus(selected);
            return;
        }

        for (int i = idx; i < possibleVirusCnt; i++) {
            selected[cnt] = i;
            selectVirus(i + 1, cnt + 1, selected);
        }
    }

    public static void spreadVirus(int[] selected) {
        Queue<Virus> q = new LinkedList<>();

        int checkCnt = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus select = viruses.get(selected[i]);

            q.add(new Virus(select.x, select.y, select.time));
            checkCnt += 1;
            visited[select.y][select.x] = true;
        }

        int curTime = 0;

        if(checkCnt == entireVirusMapCnt) {
            res = Math.min(res, curTime);
            return;
        }

        while (!q.isEmpty()) {
            int qSize = q.size();
            curTime += 1;

            for (int i = 0; i < qSize; i++) {
                Virus cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + cur.x, ny = dy[j] + cur.y;

                    if(!checkMapArrange(nx, ny)) continue;

                    if(visited[ny][nx]) continue;

                    if(initMap[ny][nx] == -1) continue;

                    q.add(new Virus(nx, ny, curTime));
                    visited[ny][nx] = true;
                    checkCnt += 1;
                }
            }

            if(checkCnt == entireVirusMapCnt) break;
        }

        if(checkCnt == entireVirusMapCnt) res = Math.min(res, curTime);
    }

    public static boolean checkMapArrange(int x, int y) {
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
