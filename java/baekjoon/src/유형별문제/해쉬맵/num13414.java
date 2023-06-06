package 유형별문제.해쉬맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num13414 {
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = stoi(st.nextToken());
        int L = stoi(st.nextToken());

        for (int i = 1; i <= L; i++) {
            String item = br.readLine();
            if(set.contains(item)) set.remove(item);
            set.add(item);
        }

        int index = 0;
        for(String x : set){
            System.out.println(x);
            if(++index == K) break;
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
