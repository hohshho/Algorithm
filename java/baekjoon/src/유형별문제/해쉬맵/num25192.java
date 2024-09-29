package 유형별문제.해쉬맵;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/25192
public class num25192 {
    static HashSet<String> set = new HashSet<>();
    static int N, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if(input.equals("ENTER")) {
                set = new HashSet<>();
                continue;
            }

            if(set.contains(input)) continue;

            set.add(input);
            result += 1;
        }

        System.out.println(result);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
