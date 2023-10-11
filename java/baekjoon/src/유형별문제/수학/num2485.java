package 유형별문제.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2485 {
    static int cnt = 0, distance = 0, N;
    static int[] trees, treeDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        trees = new int[N];
        treeDistance = new int[N - 1];

        for (int i = 0; i < N; i++) {
            trees[i] = stoi(br.readLine());

            if (i == 0) continue;

            treeDistance[i - 1] = trees[i] - trees[i - 1];
        }

        for (int i = 1; i < N - 1; i++) {
            int temp = getResult(treeDistance[i], treeDistance[i - 1]);

            if (distance == 0) {
                distance = temp;
                continue;
            }

            distance = getResult(temp, distance);
        }

        for (int i = 0; i < N - 1; i++) {
            int temp = treeDistance[i] / distance;

            if(temp == 1) continue;

            cnt += temp - 1;
        }

        System.out.println(cnt);
    }

    public static int getResult(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        while (min > 0) {
            int temp = max % min;
            max = min;
            min = temp;
        }

        return max;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
