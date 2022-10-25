package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num3986 {
    static int N, res;
    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");

            stack = new Stack<String>();
            for(int j=0; j<input.length; j++){
                if(stack.empty()){
                    stack.push(input[j]);
                    continue;
                }

                if(stack.peek().equals(input[j]))
                    stack.pop();
                else
                    stack.push(input[j]);
            }

            if(stack.empty())
                res++;
        }

        System.out.println(res);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
