package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num3079 {
    static long N, M, line[], max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = stol(input[0]);
        M = stol(input[1]);

        line = new long[(int) N];

        for(int i=0; i<N; i++){
            line[i] = stol(br.readLine());
            max = line[i] > max ? line[i] : max;
        }

        max *=M;

        System.out.println(bsearch());

    }

    public static long bsearch(){
        long result = 0;
        long start = 0, end = max, mid;

        while(end >= start){
            mid = (start + end) / 2;

            if(checkTime(mid)){
                result = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static boolean checkTime(long target){
        long cnt = 0;
        for(int i=0; i<N; i++){
            cnt +=  target / line[i];
        }

        return cnt >= M ? true : false;
    }

    public static long stol(String s){
        return Long.parseLong(s);
    }
}
