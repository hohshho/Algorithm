
import java.util.*;
import java.io.*;


public class 인증평가4차_슈퍼컴퓨터클러스터 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(list[i], max);
        }

        long left = 0;
        long right = max + B;
        long res = 0;

        while (left < right) {
            long mid = (left + right) / 2;
            if (checkList(list, mid, B)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(res);
    }

    public static boolean checkList(int[] list, long mid, long b) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] >= mid) continue;

            b -= Math.pow((mid - list[i]), 2);
        }

        if (b >= 0) return true;
        return false;
    }

}
