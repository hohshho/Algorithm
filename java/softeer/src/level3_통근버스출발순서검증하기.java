import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class level3_통근버스출발순서검증하기 {
    static int N, res = 0;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        list = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = stoi(st.nextToken());
        }

        search(0, 0, new int[3]);

        System.out.println(res);
    }

    public static void search(int idx, int cnt, int[] selected) {
        if (cnt == 3) {
            res += 1;
            return;
        }

        for (int i = idx; i < N; i++) {
            if(visited[i]) continue;

            if(cnt == 1 && selected[0] > list[i]) continue;

            if(cnt == 2 && selected[0] < list[i]) continue;

            visited[i] = true;
            selected[cnt] = list[i];
            search(i + 1, cnt + 1, selected);
            visited[i] = false;
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
