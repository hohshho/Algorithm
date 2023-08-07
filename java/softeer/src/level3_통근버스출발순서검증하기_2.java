import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class level3_통근버스출발순서검증하기_2 {
    static int N, res = 0;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = stoi(st.nextToken());
        }


        System.out.println(res);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
