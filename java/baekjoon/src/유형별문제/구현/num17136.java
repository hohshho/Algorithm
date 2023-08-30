package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num17136 {
    static int res = -1;
    static int[][] map = new int[10][10];
    static int[] papersCnt = new int[5]; // paper 사용 개수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        search(0, 0, 0);

        System.out.println(res);
    }

    public static void search(int x, int y, int cnt) {
        // 종료 조건, x = 9, y = 9 까지 탐색하기 위해 x == 10 까지 탐색
        if (x > 9 && y >= 9) {
            if (res == -1) res = cnt;
            else res = Math.min(res, cnt);
            return;
        }

        if(res != -1 && cnt > res) return;

        // 열 이동
        if (x > 9) {
            search(0, y + 1, cnt);
            return;
        }

        // 색종이 붙일 필요 없으면 pass
        if (map[y][x] == 0) {
            search(x + 1, y, cnt);
            return;
        }

        // 사이즈 큰 것 부터 탐색
        for (int size = 5; size > 0; size--) {
            // 붙일 수 없으면 다음 사이즈 search
            if (!checkUsablePaperSize(x, y, size)) continue;

            // 남은 paper 검사
            if (papersCnt[size - 1] == 5) continue;

            // 색종이 사용 처리 (0으로 처리해 pass되게)
            changePaperState(x, y, size, 0);

            search(x + size, y, cnt + 1);

            // 색종이 제거 처리 (1로 처리해 다시 탐색 가능하게)
            changePaperState(x, y, size, 1);
        }
    }

    public static void changePaperState(int x, int y, int size, int state) {
        if(state == 0) papersCnt[size - 1] += 1;
        else papersCnt[size - 1] -= 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[y + j][x + i] = state;
            }
        }
    }

    public static boolean checkUsablePaperSize(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int nx = x + j, ny = y + i;

                // 범위 초과 시 false
                if (!checkMapArrange(nx, ny)) return false;

                // 붙일 공간 없으면 false;
                if (map[ny][nx] == 0) return false;
            }
        }

        return true;
    }

    public static boolean checkMapArrange(int x, int y) {
        return x >= 0 && y >= 0 && x < 10 && y < 10;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
