package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num16401 {
    static int M, N;
    static int[] list;
    static int max = 0;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = stoi(st.nextToken());
            max = Math.max(max, list[i]);
        }

        Arrays.sort(list);

        int end = max, start = 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = checkList(mid);

            if (cnt >= M) {
                res = mid;
                start = mid + 1;
            }

            if (cnt < M) {
                end = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static int checkList(int mid) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int cur = list[i];

            while (cur >= mid) {
                cur -= mid;
                cnt += 1;
            }
        }

        return cnt;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
