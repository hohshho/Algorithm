package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num1764 {
    static int N, M, result = 0;
    static HashMap<String, String> map = new HashMap<>();
    static HashMap<String, String> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = stoi(input[0]);
        M = stoi(input[1]);
        List<String> result = new ArrayList<>();

        for(int i=0; i<N; i++){
            map.put(br.readLine(), "true");
        }

        for(int i=0; i<M; i++){
            map2.put(br.readLine(), "true");
        }

        for( String strKey : map.keySet() ){
            if(map2.containsKey(strKey)){
                result.add(strKey);
            }
        }

        Collections.sort(result);

        sb.append(result.size() + "\n");
        for(String item : result){
            sb.append(item + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
