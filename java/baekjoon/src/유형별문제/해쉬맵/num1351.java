package 유형별문제.해쉬맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num1351 {
    static long n, p, q;
    static HashMap<Long, Long> map = new HashMap<Long, Long>();

    static long search(long n) {
        if (n == 0)
            return 1;

        if (map.containsKey(n))
            return map.get(n);

        map.put(n, search(n / p) + search(n / q));

        return map.get(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = stol(input[0]);
        p = stol(input[1]);
        q = stol(input[2]);

        System.out.println(search(n));
    }

    public static long stol(String s){
        return Long.parseLong(s);
    }
}

