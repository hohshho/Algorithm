package 단계별풀어보기.level17_스택;

import java.util.*;
import java.io.*;

public class num4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals("")) {
                bw.flush();
                return;
            }

            bw.write(isBalanced(input));
        }
    }

    // use Stack
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;

        for (char one : s.toCharArray()) {
            if (one == '(' || one == '[') {
                stack.push(one);
            } else if (one == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    result = false;
                    break;
                }
            } else if (one == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    result = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            result = false;
        }

        return result ? "yes\n" : "no\n";
    }
}