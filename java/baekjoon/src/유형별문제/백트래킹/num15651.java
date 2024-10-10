package 유형별문제.백트래킹;

import java.util.*;
import java.io.*;

public class num15651 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        rePermutation(0, new int[M]);

        System.out.println(sb.toString());
    }

    public static void rePermutation(int cnt, int[] selected) {
        if(M == cnt) {
            for(int item : selected) {
                sb.append(item + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            selected[cnt] = i;
            rePermutation(cnt + 1, selected);
        }

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
