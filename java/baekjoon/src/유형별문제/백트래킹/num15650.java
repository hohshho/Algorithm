package 유형별문제.백트래킹;

import java.util.*;
import java.io.*;

public class num15650 {
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        combination(1, 0, new int[M]);

    }

    public static void combination(int idx, int cnt, int[] selected) {
        if(cnt == M) {
            for(int item : selected) {
                System.out.print(item + " " );
            }
            System.out.println("");
            return;
        }

        for(int i=idx; i <= N; i++){
            selected[cnt] = i;
            combination(i + 1, cnt + 1, selected);
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
