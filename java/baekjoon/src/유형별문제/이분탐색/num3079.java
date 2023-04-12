package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num3079 {

    static int N, M;
    static int[] line;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = stoi(input[0]);
        M = stoi(input[1]);

        line = new int[N];

        for (int i = 0; i < N; i++) {
            line[i] = stoi(br.readLine());
            max = line[i] > max ? line[i] : max;
        }

        Arrays.sort(line);
        max *= M;

        System.out.println(bsearch());

    }

    public static long bsearch(){
        long result = Long.MAX_VALUE;
        long start = 0, end = max, mid;

        while(end >= start){
            mid = (start + end) / 2;

            if(checkTime(mid)){
                result = Math.min(result, mid);
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static boolean checkTime(long target) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (target / line[i]);
            if (sum >= M) break;
        }

        return sum >= M ? true : false;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
