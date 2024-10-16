package 유형별문제.재귀;

import java.util.*;
import java.io.*;

public class num1629_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = stoi(st.nextToken());
        int B = stoi(st.nextToken());
        int C = stoi(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(long A,long B, long C){
        if(B == 1) return A % C;
        long val = pow(A, B/2, C);
        val = val * val % C;
        if(B%2 == 0) return val;
        return val * A % C;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
