package 유형별문제.그리디;

import java.io.*;
import java.util.*;

public class num11047 {
    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        coins = new int[N];

        for(int i=0; i<N; i++){
            coins[i] = stoi(br.readLine());
        }

        int idx = coins.length - 1;
        int cnt = 0;
        for(int i = coins.length - 1; i >= 0; i--){
            if(K / coins[i] == 0) continue;

            cnt += (K / coins[i]);
            K = K % coins[i];
        }

        System.out.println(cnt);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
