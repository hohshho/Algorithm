package 유형별문제.해쉬맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/26069
public class num26069 {
    static int N;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        set.add("ChongChong");

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            if(set.contains(p1)) {
                set.add(p2);
            }
            else if(set.contains(p2)) {
                set.add(p1);
            }
        }

        System.out.println(set.size());

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
