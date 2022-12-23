package 유형별문제.해쉬맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num14425 {
    static int N, M, result = 0;
    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = stoi(input[0]);
        M = stoi(input[1]);

        for(int i=0; i<N; i++){
            map.put(br.readLine(), "true");
        }

        for(int i=0; i<M; i++){
            if(map.containsKey(br.readLine())){
                result++;
            }
        }

        System.out.println(result);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
