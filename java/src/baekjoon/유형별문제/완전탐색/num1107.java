package bruteFoce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1107 {
    static int N, M, result;
    static boolean[] brokenBtn = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        M = stoi(br.readLine());

        if (M != 0) {
            String[] brokenBtnList = br.readLine().split(" ");
            for (String item : brokenBtnList) {
                brokenBtn[stoi(item)] = true;
            }
        }

        result = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            int cnt = checkNumberPushCnt(i);

            // 숫자 버튼 눌러서 이동 한 경우
            if (cnt > 0) {
                cnt += Math.abs(N - i);
                result = Math.min(cnt, result);
            }
        }

        System.out.println(result);
    }

    public static int checkNumberPushCnt(int n) {
        if (n == 0) {
            if (brokenBtn[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int cnt = 0;
        while (n > 0) {
            if (brokenBtn[n % 10]) {
                return 0;
            }
            n /= 10;
            cnt++;
        }
        return cnt;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
