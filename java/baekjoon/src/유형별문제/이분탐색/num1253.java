package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1253 {
    static int N, res = 0;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = stoi(st.nextToken());
        }

        Arrays.sort(map);

        for (int i = 0; i < N; i++) {
            if (bSearch(i)) {
                res += 1;
            }
        }

        System.out.println(res);
    }

    public static boolean bSearch(int index) {
        int right = N - 1, left = 0;

        // 현재 index의 위치에 있는 경우
        if (left == index) left++;
        else if (right == index) right--;

        while (right > left) {
            int sum = map[right] + map[left];

            if (sum == map[index]) return true;

            if (sum > map[index]) {
                right -= 1;
            } else {
                left += 1;
            }

            // 현재 index의 위치에 있는 경우
            if (left == index) left++;
            else if (right == index) right--;
        }

        return false;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
