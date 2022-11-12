package MinPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1261 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = stoi(input[1]); // 행
        M = stoi(input[0]); // 열


        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                stoi(input[j]);
            }
        }

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
