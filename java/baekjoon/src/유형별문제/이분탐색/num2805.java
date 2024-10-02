package 유형별문제.이분탐색;

import java.io.*;
import java.util.*;

public class num2805 {
    static int N, M;
    static long max = 0;
    static int[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            list[i] = stoi(st.nextToken());
        }

        bSearch();

        System.out.println(max);
    }

    public static void bSearch() {
        long start = 0;
        long end = 1000000000;

        while(start<=end) {
            long mid = (start + end) / 2;

            if(cut(mid)) {
                start = mid + 1;
                max = Math.max(mid, max);
            }
            else {
                end = mid - 1;
            }
        }
    }

    public static boolean cut(long mid) {
        long treeLen = 0;

        for(int i=0; i<N; i++){
            long curLen = list[i] - mid;

            if(curLen >= 0) treeLen += curLen;
        }

        if(treeLen >= M) return true;
        return false;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
