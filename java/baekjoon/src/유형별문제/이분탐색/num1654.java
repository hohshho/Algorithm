package 유형별문제.이분탐색;

import java.io.*;
import java.util.*;

public class num1654 {
    static int K, N;
    static int[] list;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = stoi(st.nextToken());
        N = stoi(st.nextToken());
        // int형 최대값 10억 안넘어가면 괜찮은걸로 이해하자
        max = 0;
        list = new int[K];

        for(int i=0; i<K; i++){
            list[i] = stoi(br.readLine());
            max = Math.max(list[i], max);
        }

        Bsearch();

        System.out.println(max);
    }

    public static void Bsearch() {
        // 이분탐색은 Long형으로 체크하자
        long start = 1;
        long end = max;
        max = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            int cnt = 0;

            for(int i=0; i<list.length; i++){
                cnt += list[i] / mid;
            }

            if(cnt >= N) {
                start = mid + 1;
                max = Math.max(max, mid);
            }
            else {
                end = mid - 1;
            }
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
