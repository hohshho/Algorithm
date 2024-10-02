package 유형별문제.누적합;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2559
public class num2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K, result = Integer.MIN_VALUE + 1;

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        int[] list = new int[N];
        int[] pSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            list[i] = stoi(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            pSum[i] = pSum[i-1] + list[i-1];
        }

        for(int i=0; i<=N-K; i++){
            int start = i;
            int end = i + K;

            int num = pSum[end] - pSum[start];

            result = Math.max(num, result);
        }

        System.out.println(result);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
