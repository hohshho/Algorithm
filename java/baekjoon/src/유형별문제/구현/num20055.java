package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num20055 {
    static int N, K;
    static int res = 0;
    static int[] line, robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        line = new int[2 * N];
        robots = new int[N];

        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < inputs.length; i++) {
            line[i] = stoi(inputs[i]);
        }

        run();

        System.out.println(res);
    }

    public static void run() {

        while (checkLine()) {
            // 1. 회전
            int upLineItem = line[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                line[i] = line[i - 1];
            }
            line[0] = upLineItem;

            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = 0;
            robots[N - 1] = 0;

            for (int i = N - 1; i > 0; i--) {   // 2. 로봇 이동가능하면 이동
                if (robots[i - 1] == 1 && robots[i] == 0 && line[i] >= 1) {
                    robots[i] = 1;
                    robots[i - 1] = 0;
                    line[i]--;
                }
            }

            if (line[0] > 0) {     // 3. 올라가는 위치에 로봇 올리기
                robots[0] = 1;
                line[0]--;
            }

            res++;
        }
    }

    public static boolean checkLine() {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (line[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }

        return true;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
