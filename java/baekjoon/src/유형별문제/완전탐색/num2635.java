package 유형별문제.완전탐색;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2635
public class num2635 {
    static int start, maxLen = 1;
    static LinkedList<Integer> maxList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = stoi(br.readLine());

        int prev, cur;
        for(int i=1; i<=start; i++){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(start);
            list.add(i);

            prev = start;
            cur = i;
            int cnt = 2;
            while(prev - cur >= 0) {
                int next = prev - cur;
                list.add(next);
                prev = cur;
                cur = next;
                cnt += 1;
            }

            if(cnt > maxLen) {
                maxLen = cnt;
                maxList = list;
            }
        }

        System.out.println(maxLen);
        for(int item : maxList) {
            System.out.print(item + " ");
        }

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
