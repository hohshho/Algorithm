package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num9019 {
    static int T;
    static String[] res;
    static String[] go = new String[]{"D", "S", "L", "R"};
    static Queue<Register> q;
    static boolean[] visit = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());
        res = new String[T];

        for (int i = 0; i < T; i++) {
            String[] AB = br.readLine().split(" ");
            int A = stoi(AB[0]);
            int B = stoi(AB[1]);

            q = new LinkedList<>();
            visit = new boolean[10000];
            search(A, B, i);
        }

        for (String item : res) {
            System.out.println(item);
        }
    }

    public static void search(int A, int B, int index) {
        q.add(new Register(A, ""));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int si = 0; si < size; si++) {
                Register cur = q.poll();
                if (cur.num == B) {
                    res[index] = cur.command;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int cx = cur.run(go[i]);
                    if (!visit[cx]) {
                        q.add(new Register(cx, cur.command + go[i]));
                        visit[cx] = true;
                    }
                }
            }
        }
    }

    static class Register {
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int run (String run) {
            if(run.equals("D")){
                return (num * 2) % 10000;
            }else if(run.equals("S")){
                return num == 0 ? 9999 : num - 1;
            }else if(run.equals("L")){
                return num % 1000 * 10 + num / 1000;
            }else if(run.equals("R")){
                return num % 10 * 1000 + num / 10;
            }
            return 0;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
