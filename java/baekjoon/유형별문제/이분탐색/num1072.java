package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int x = stoi(input[0]);
        int y = stoi(input[1]);
        int z = getPercent(x, y);

        int ans = -1;
        int start = 0;
        int end = 1000000000;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getPercent(x + mid, y + mid) != z) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
