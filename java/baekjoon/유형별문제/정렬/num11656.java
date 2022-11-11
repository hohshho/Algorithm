package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] res = new String[input.length()];

        for(int i=0; i<input.length(); i++){
            res[i] = input.substring(i);
        }

        Arrays.sort(res);

        for(String item : res){
            System.out.println(item);
        }

    }
}
