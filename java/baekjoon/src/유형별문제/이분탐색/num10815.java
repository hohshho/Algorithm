package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num10815 {
    static int N, M;
    static int[] cards, lists, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());
        cards = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            cards[i] = stoi(input[i]);
        }

        M = stoi(br.readLine());
        lists = new int[M];
        result = new int[M];
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            lists[i] = stoi(input2[i]);
        }

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            result[i] = bsearch(lists[i]);
        }

        for (int item : result) {
            sb.append(item + " ");
        }

        System.out.println(sb.toString());
    }

    public static int bsearch(int target) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == cards[mid]) {
                return 1;
            }
            if (cards[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
