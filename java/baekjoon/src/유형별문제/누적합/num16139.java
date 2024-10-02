package 유형별문제.누적합;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16139
public class num16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();

        int[][] pSum = new int[26][input.length + 1];

        for (int i = 1; i <= input.length; i++) {
            for (int j = 0; j < 26; j++) {
                pSum[j][i] = pSum[j][i - 1];
            }

            int num = input[i - 1] - 'a';

            pSum[num][i] += 1;
        }

        int T = stoi(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // string to char
            int item = st.nextToken().charAt(0) - 'a';
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            sb.append(pSum[item][end + 1] - pSum[item][start] + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
