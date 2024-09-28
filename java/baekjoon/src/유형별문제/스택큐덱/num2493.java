package 유형별문제.스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num2493 {
    static long N;
    static Stack<Long[]> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stol(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            long item = stol(input[i]);

            while(!stack.empty()){
                if(stack.peek()[0] >= item) {
                    sb.append(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new Long[] {item, (long) i + 1});
        }

        System.out.println(sb.toString());
    }

    public static long stol(String s){
        return Long.parseLong(s);
    }
}
