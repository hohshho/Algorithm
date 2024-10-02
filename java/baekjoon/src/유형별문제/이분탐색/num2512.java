package 유형별문제.이분탐색;

import java.io.*;
import java.util.*;

public class num2512 {
    static int N;
    static long M, max = 0, result;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];

        for(int i=0; i<N; i++){
            list[i] = stoi(st.nextToken());
            max = Math.max(list[i], max);
        }

        M = stol(br.readLine());

        bSearch();

        System.out.println(result);
    }

    public static void bSearch(){

        long start = 0;
        long end = max;
        while(start <= end) {
            long mid = (start + end) / 2;

            int sum = 0;
            for(int i=0; i<N; i++){
                sum += Math.min(list[i], mid);
            }
            if(sum <= M) {
                start = mid + 1;
                result = Math.max(mid, result);
            }
            else{
                end = mid - 1;
            }

        }


    }



    private static long stol(String s){
        return Long.parseLong(s);
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
