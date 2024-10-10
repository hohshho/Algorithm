package 유형별문제.스택큐덱;

import java.util.*;
import java.io.*;

public class num5397 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = stoi(br.readLine());

        while(T-- > 0) {
            char[] input = br.readLine().toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            int curIdx = 0;

            for(char item : input){
                if('<' == item) {
                    if(curIdx != 0) curIdx -= 1;
                }
                else if('>' == item) {
                    if(curIdx < list.size()) curIdx += 1;
                }
                else if('-' == item) {
                    if(curIdx > 0) list.remove(--curIdx);
                }
                else {
                    list.add(curIdx++, item);
                }
            }
            for(char item : list){
                sb.append(item);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
