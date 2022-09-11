package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1166 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = stoi(br.readLine());
        long l = stoi(br.readLine());
        long w = stoi(br.readLine());
        long h = stoi(br.readLine());

        double start = 0;
        double end = Math.max(l, Math.max(w, h));

        for (int i = 0; i < 10000; i++) {
            double mid = (start + end) / 2;

            if ((long) (l / mid) * (long) (w / mid) * (long) (h / mid) >= n) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        System.out.println(start);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
