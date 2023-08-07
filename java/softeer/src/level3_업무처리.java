import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class level3_업무처리 {
    static int H, K, R;
    static Node[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        K = stoi(st.nextToken());
        R = stoi(st.nextToken());

        tree = new Node[H + 1][(int) Math.pow(2, H)]; // 높이, 높이 * 2

        // 루트 노드
        tree[0][0] = new Node();

        // 중간 노드
        for (int i = 1; i < H; i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                tree[i][j] = new Node();
            }
        }

        // 말단 노드
        for (int i = 0; i < Math.pow(2, H); i++) {
            String[] input = br.readLine().split(" ");
            tree[H][i] = new Node(input);
        }

        int cnt = 0;
        for (int day = 1; day <= R; day++) {
            // 루트 노드 처리
            if (day % 2 == 1 && !tree[0][0].left.isEmpty()) {
                cnt += tree[0][0].left.poll();
            } else if (day % 2 == 0 && !tree[0][0].right.isEmpty()) {
                cnt += tree[0][0].right.poll();
            }

            // 중간 노드 처리
            for (int i = 1; i < H; i++) {
                for (int j = 0; j < Math.pow(2, i); j++) {
                    // 왼쪽
                    if (day % 2 == 1 && !tree[i][j].left.isEmpty()) {
                        int work = tree[i][j].left.poll();

                        if(j % 2 == 0) { // 왼쪽 자식
                            tree[i - 1][j / 2].left.add(work);
                        }else { // 오른쪽 자식
                            tree[i - 1][j / 2].right.add(work);
                        }
                    }
                    // 오른쪽
                    else if (day % 2 == 0 && !tree[i][j].right.isEmpty()) {
                        int work = tree[i][j].right.poll();

                        if(j % 2 == 0) { // 왼쪽 자식
                            tree[i - 1][j / 2].left.add(work);
                        }else { // 오른쪽 자식
                            tree[i - 1][j / 2].right.add(work);
                        }
                    }
                }
            }

            // 말단 노드 처리
            for (int i = 0; i < Math.pow(2, H); i++) {
                if (tree[H][i].work.isEmpty()) continue;

                // i % 2 == 0 왼쪽
                if (i % 2 == 0) {
                    tree[H - 1][i / 2].left.add(tree[H][i].work.poll());
                }
                // i % 2 == 1 오른쪽
                else {
                    tree[H - 1][i / 2].right.add(tree[H][i].work.poll());
                }
            }
        }

        System.out.println(cnt);
    }

    public static class Node {
        LinkedList<Integer> left, right, work;

        Node() {
            this.left = new LinkedList<>();
            this.right = new LinkedList<>();
        }

        Node(String[] list) {
            this.work = new LinkedList<>();

            for (String item : list) {
                work.add(stoi(item));
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}