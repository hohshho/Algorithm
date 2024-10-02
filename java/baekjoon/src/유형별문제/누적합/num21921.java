package 유형별문제.누적합;


import java.io.*;
import java.util.*;

// https://www.acmicpc.net/status?user_id=tkdgur8377&problem_id=21921&from_mine=1
public class num21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int X = stoi(st.nextToken());
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[] pSum = new int[N + 1];
        for(int i=0; i<N; i++){
            list[i] = stoi(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            pSum[i] = pSum[i-1] + list[i-1];
        }

        for(int i=0; i<=N-X; i++){
            int s = i;
            int e = i+X;

            int num = pSum[e] - pSum[s];

            if(num > max) {
                max = num;
                cnt = 1;
            }
            else if (num == max){
                cnt += 1;
            }
        }


        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
