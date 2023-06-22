package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num3151 {
    static int N;
    static long cnt = 0;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = stoi(st.nextToken());
        }

        Arrays.sort(list);

        for (int first = 0; first < N; first++) {
            if (list[first] > 0) break;

            int second = first + 1;
            int third = N - 1;

            while (second < third) {
                int curSum = listSum(first, second, third);

                if (curSum == 0) {
                    int l = 1;
                    int r = 1;

                    // list내 동일 항목 처리
                    if (list[second] == list[third]) {
                        int n = third - second + 1;
                        cnt += combination(n);
                        break;
                    }
                    while (list[second] == list[second + 1]) {
                        l++;
                        second++;
                    }
                    while (list[third] == list[third - 1]) {
                        r++;
                        third--;
                    }

                    cnt += l * r;
                }

                if (curSum > 0) {
                    third--;
                } else {
                    second++;
                }

            }

        }
        System.out.println(cnt);
    }

    public static long combination(int n){
        return n * (n - 1) / 2;
    }

    public static int listSum(int first, int second, int third) {
        return list[first] + list[second] + list[third];
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
