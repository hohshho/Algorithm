package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2022 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        double left = 0, right = Math.min(x, y);

        while (right - left >= 0.001) {
            // 닮음
            double width = (left + right) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2));
            double res = (h1 * h2) / (h1 + h2);

            // 피타고라스
            if (res >= c) left = width;
            else right = width;
        }
        System.out.println(String.format("%.3f", right));
    }
}
