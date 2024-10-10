package 유형별문제.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13300
public class num13300 {
    static int N, K;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new int[6][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int curS = stoi(st.nextToken());
            int curY = stoi(st.nextToken()) - 1;

            list[curY][curS] += 1;
        }

        int result = 0;
        for(int i=0; i<6; i++){
            result += (list[i][0] / K);
            result += (list[i][1] / K);

            if(list[i][0] % K != 0) result += 1;
            if(list[i][1] % K != 0) result += 1;
        }

        System.out.println(result);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
