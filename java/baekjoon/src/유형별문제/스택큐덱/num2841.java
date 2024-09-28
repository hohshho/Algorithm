package 유형별문제.스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num2841 {
    static int N, P, res = 0, line, flat;
    static Stack<Integer>[] stList = new Stack[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NP = br.readLine().split(" ");

        N = stoi(NP[0]);
        P = stoi(NP[1]);


        for(int i=0; i<6; i++){
            stList[i] = new Stack<Integer>();
        }

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");

            line = stoi(input[0]) - 1;
            flat = stoi(input[1]);

            while(!stList[line].empty()) {
                if(stList[line].peek() < flat) {
                    stList[line].push(flat);
                } else if (stList[line].peek() > flat){
                    stList[line].pop();
                } else {
                    break;
                }
                res++;
            }

            if(stList[line].empty()){
                stList[line].push(flat);
                res++;
            }
        }

        System.out.println(res);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
