package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num15903 {
    static Long N, m, result= Long.valueOf(0);
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = stol(input[0]);
        m = stol(input[1]);

        String[] nums = br.readLine().split(" ");

        for (String item : nums) {
            pq.add(stol(item));
        }

        for (int i = 0; i < m; i++) {
            Long num1 = pq.remove();
            Long num2 = pq.remove();
            pq.add(num1+num2);
            pq.add(num1+num2);
        }

        while(!pq.isEmpty()){
            result += pq.remove();
        }

        System.out.println(result);

    }

    public static Long stol(String s) {
        return Long.parseLong(s);
    }
}
