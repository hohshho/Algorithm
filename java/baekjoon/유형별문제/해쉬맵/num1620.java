package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num1620 {
    static int N, M, result = 0;
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static HashMap<Integer, String> map2 = new HashMap<Integer, String>();
    static String item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = stoi(input[0]);
        M = stoi(input[1]);

        for(int i=0; i<N; i++){
            item = br.readLine();
            map.put(item, i+1);
            map2.put(i+1, item);
        }

        for(int i=0; i<M; i++){
            item = br.readLine();
            if(map.containsKey(item)){
                sb.append(map.get(item) + "\n");
            }else {
                sb.append(map2.get(stoi(item)) + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
