package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1477 {
    static int N, M, L;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NML = br.readLine().split(" ");

        N = stoi(NML[0]);
        M = stoi(NML[1]);
        L = stoi(NML[2]);
        list = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            list[i] = stoi(st.nextToken());
        }
        list[0] = 0;
        list[N + 1] = L;
        Arrays.sort(list);

        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    public static boolean check(int mid) {
        int count = 0;

        for(int i = 1; i < N+2; i++) {
            count += (list[i] - list[i-1] - 1) / mid;
        }

        return count > M;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
