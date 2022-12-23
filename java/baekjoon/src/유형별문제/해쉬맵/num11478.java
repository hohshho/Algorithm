package 유형별문제.해쉬맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num11478 {
    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split("");
        String str = "";

        for(int i=0; i< input.length; i++){
            str = "";
            for(int j=i; j< input.length; j++){
                str += input[j];
                map.put(str, str);
            }

        }

        System.out.println(map.size());

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
