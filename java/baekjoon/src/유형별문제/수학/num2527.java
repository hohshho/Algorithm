package 유형별문제.수학;

import java.io.*;
import java.util.*;

public class num2527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int p1 = stoi(st.nextToken());
            int q1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());
            int p2 = stoi(st.nextToken());
            int q2 = stoi(st.nextToken());

            if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                System.out.println("d");
            }
            else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
                System.out.println("c");
            }
            else if (p1 == x2 || q1 == y2|| p2 == x1 || y1 == q2){
                System.out.println("b");
            }
            else {
                System.out.println("a");
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
