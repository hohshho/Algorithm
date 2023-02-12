package 유형별문제.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class num16922 {
    static int N;
    static int res = 0;
    static HashSet<Integer> visited = new HashSet<>();
    static int[] list = new int[] {1, 5, 10, 50};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        combination(0, 0, 0);

        System.out.println(res);
    }

    public static void combination(int cnt, int idx, int sum) {
        if (cnt == N) {
            if(!visited.contains(sum)){
                visited.add(sum);
                res++;
            }
            return;
        }

        for (int i = idx; i < 4; i++) {
            combination(cnt + 1, i, sum + list[i]);
        }

    }
}
