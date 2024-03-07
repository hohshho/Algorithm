import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        String result = convertToBase(n, k);

        System.out.println(result);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static String convertToBase(int n, int x) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int remainder = n % x;
            char digit = (char) ('0' + remainder);

            if (remainder >= 10) {
                digit = (char) ('A' + (remainder - 10));
            }
            result.insert(0, digit);
            n /= x;
        }

        return result.toString();
    }
}