package 유형별문제.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num14002 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());

        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = stoi(input[i]);
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        System.out.println(res);
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            if(dp[i] == res) {
                stack.push(arr[i]);
                res--;
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}