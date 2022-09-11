package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num1269 {
    static HashMap<Integer, Integer> A = new HashMap<>();
    static HashMap<Integer, Integer> B = new HashMap<>();
    static int N, M, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = stoi(input[0]);
        M = stoi(input[1]);

        String[] Alist = br.readLine().split(" ");
        String[] Blist = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            A.put(stoi(Alist[i]), i);
        }

        for(int i=0; i<M; i++){
            int value = stoi(Blist[i]);
            B.put(value, i);

            // B-A
            if(!A.containsKey(value)){
                result++;
            }
        }

        for(int key : A.keySet()){
            if(!B.containsKey(key)) {
                result++;
            }
        }

        System.out.println(result);

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
