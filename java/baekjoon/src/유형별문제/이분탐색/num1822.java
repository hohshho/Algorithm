package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num1822 {
    static TreeSet<Integer> A = new TreeSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            A.add(stoi(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int item = stoi(st.nextToken());

            if (A.contains(item)) A.remove(item);
        }

        System.out.println(A.size());
        for (int item : A) {
            System.out.print(item + " ");
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
