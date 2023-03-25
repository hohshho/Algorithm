package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num15684 {
    static int N, M, H, res = -1; // 3개 이상 추가 시 -1
    static boolean[][] originMap;
    static boolean[][] visitedMap;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashMap<Integer, Integer> copyMap;

    public static void main(String[] args) throws IOException {
//        5 5 6 : N (세로선) -> x, M (가로선 입력 개수), 가로선 위치 개수 H -> y
//        1 1 (가로선 높이 - 1, b -> b + 1)
//        3 2
//        2 3
//        5 1
//        5 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMH = br.readLine().split(" ");

        N = stoi(NMH[0]);
        M = stoi(NMH[1]);
        H = stoi(NMH[2]);

        originMap = new boolean[H][N];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            int y = stoi(input[0]) - 1;
            int x = stoi(input[1]) - 1;

            originMap[y][x] = true;
            originMap[y][x + 1] = true;
            map.put(N * y + x, N * y + x + 1);
        }

        // 가로선 연속 x
        for (int i = 0; i < 4; i++) {
            visitedMap = new boolean[H][N];
            visitedMap = originMap.clone();
            copyMap = new HashMap<>();
            copyMap = (HashMap<Integer, Integer>) map.clone();

            if (i == 0) {
                if (!checkLadder()) continue;

                System.out.println(i);
                return;
            }

            addLadder(i, 0, new int[i]);

            if (res != -1) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(res);
    }

    public static void addLadder(int max, int selectCount, int[] selected) {
        if (selectCount == max) {
            if (checkLadder()) {
                res = max;
            }
            return;
        }

        if (res != -1) {
            return;
        }

        int startIdx = selectCount == 0 ? 0 : selected[selectCount - 1];
        for (int i = startIdx; i < N * H; i++) {
            // 마지막 선 pass
            if (i % N == N - 1) continue;

            if (visitedMap[i / N][i % N]) continue;


            int y = i / N;
            int x = i % N;

            int point = y * N + x;

            if(copyMap.containsKey(point + 1)) continue;

            selected[selectCount] = i;
            visitedMap[y][x] = true;
            visitedMap[y][x + 1] = true;
            copyMap.put(point, point + 1);
            addLadder(max, selectCount + 1, selected);
            copyMap.remove(point);
            visitedMap[y][x] = false;
            visitedMap[y][x + 1] = false;
        }

    }

    public static boolean checkLadder() {
        for (int i = 0; i < N; i++) {
            int position = i;

            for (int j = 0; j < H; j++) {
                if (!visitedMap[j][position]) {
                    continue;
                }

                int point = j * N + position;
                // key에 있으면 큰 위치로 이동
                if (copyMap.containsKey(point)) {
                    position += 1;
                    continue;
                }
                // key 없으면 아래로 이동
                else {
                    position -= 1;
                    continue;
                }
            }

            if (position != i) return false;
        }

        return true;
    }

    public static boolean checkPosition(int position) {
        return position >= 0 && position < N;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
