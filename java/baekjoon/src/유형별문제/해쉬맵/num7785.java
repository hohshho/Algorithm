package 유형별문제.해쉬맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class num7785 {
    static int N;
    static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");

            if(input[1].equals("enter")){
                map.put(input[0], "enter");
            }else {
                map.remove(input[0]);
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, Collections.reverseOrder());

        for(String item : keySet){
            System.out.println(item);
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
