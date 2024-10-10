package 유형별문제.배열;

import java.io.*;
import java.util.*;

public class num10808 {
    static int[] list = new int[26];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        for(char item : input){
            list[item - 'a'] += 1;
        }

        for(int i=0; i<list.length; i++){
            System.out.print(list[i] + " " );
        }
        System.out.println();

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
