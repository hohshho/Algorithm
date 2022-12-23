package 유형별문제.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num1715 {
    static Long N, m, result= Long.valueOf(0);
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stol(br.readLine());

        for (int i=0; i<N; i++){
            pq.add(stol(br.readLine()));
        }


        while(pq.size() > 1){
            long num1 = pq.remove();
            long num2 = pq.remove();

            result += (num1 + num2);
            pq.add(num1 + num2);
        }

        System.out.println(result);

    }

    public static Long stol(String s) {
        return Long.parseLong(s);
    }
}
