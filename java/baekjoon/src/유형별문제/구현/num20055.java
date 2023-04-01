package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num20055 {
    static int N, K;
    static int res = 0;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        line = new int[2 * N];

        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < inputs.length; i++) {
            line[i] = stoi(inputs[i]);
        }

        run();

        System.out.println(res);
    }

    public static void run() {

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
