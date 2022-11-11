package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num14226 {
    static int S, res;
    static String command[] = new String[]{"save", "paste", "delete"};
    static boolean[][] visited = new boolean[1001][1001];
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = stoi(br.readLine());

        getResult();

        System.out.println(res);

    }

    public static void getResult() {
        int cnt = 0;
        q.add(new Node(0, 1));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            cnt += 1;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                for (int j = 0; j < command.length; j++) {
                    Node next = run(cur, command[j]);

                    if (next.view > 0 && next.view <= 1000) {
                        if (!visited[next.clipboard][next.view]) {
                            visited[next.clipboard][next.view] = true;

                            if (next.view == S) {
                                res = cnt;
                                return;
                            }

                            q.add(next);
                        }
                    }
                }
            }

        }
    }

    public static Node run(Node node, String command) {
        int clipboard = node.clipboard;
        int view = node.view;

        if (command.equals("save")) {
            clipboard = view;
        } else if (command.equals("paste")) {
            view = view + clipboard;
        } else {
            view -= 1;
        }

        Node newNode = new Node(clipboard, view);

        return newNode;
    }

    static class Node {
        int clipboard, view;

        Node(int clipboard, int view) {
            this.clipboard = clipboard;
            this.view = view;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
