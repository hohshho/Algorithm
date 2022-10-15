package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num6198 {
    static int N, result;
    static Stack<Long> stack = new Stack<>();
    static long[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        list = new long[(int) N];

        for (int i = 0; i < N; i++) {
            list[i] = stoi(br.readLine());
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() <= list[i]) {
                stack.pop();
            }

            stack.push(list[i]);
            result += stack.size() - 1;
        }

        System.out.println(result);

    }

    public static long stol(String s) {
        return Long.parseLong(s);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
