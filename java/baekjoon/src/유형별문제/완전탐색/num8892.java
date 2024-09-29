package 유형별문제.완전탐색;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/8892
public class num8892 {
    static int T, K;
    static String[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());

        while(T-->0) {
            K = stoi(br.readLine());

            list = new String[K];

            for(int i=0; i<K; i++){
                list[i] = br.readLine();
            }

            boolean success = false;
            for(int i=0; i<K-1; i++){
                for(int j = i + 1; j<K; j++){
                    success = isPalindrome(list[i], list[j]);

                    if(success) {
                        System.out.println(list[i] + list[j]);
                        break;
                    }

                    success = isPalindrome(list[j], list[i]);

                    if(success) {
                        System.out.println(list[j] + list[i]);
                        break;
                    }
                }
                if(success) break;
            }

            if(!success) System.out.println("0");
        }
    }

    public static boolean isPalindrome(String a, String b){
        String temp = a + b;
        // aababa 0
        for(int i=0; i<temp.length() / 2; i++){
            if(temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) return false;
        }
        return true;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
