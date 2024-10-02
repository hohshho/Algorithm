package 유형별문제.누적합;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11441
public class num11441 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];

        for(int i=0; i<N; i++){
            list[i] = stoi(st.nextToken());
        }

        //
        int[] pSum = new int[N + 1];
        for(int i=1; i<=N; i++){
            pSum[i] = list[i-1] + pSum[i - 1];
        }

        int T = stoi(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());

            // 이전까지의 합
            int num = pSum[e] - pSum[s - 1];

            System.out.println(num);
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
