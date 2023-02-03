package 유형별문제.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class num5648 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(sc.next());
        Long[][] arr = new Long[N][N];

        for (int i = 0; i < N; i++) {
            arr[i][i] = reverseStol(sc.next());
        }

        Arrays.sort(arr);

        sb.setLength(0);
        for(Long[] item : arr){
            sb.append(item + "\n");
        }

        System.out.println(sb.toString());

    }

    public static Long reverseStol(String s){
        sb.setLength(0);
        return Long.parseLong(sb.append(s).reverse().toString());
    }
}
