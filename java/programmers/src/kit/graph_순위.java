package kit;

import java.util.*;

public class graph_순위 {
    static int personCnt, answer = 0;
    static LinkedList<LinkedList<Integer>> winAdj = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> loseAdj = new LinkedList<>();

    public int solution(int n, int[][] results) {
        personCnt = n;

        for (int i = 0; i <= n; i++) {
            winAdj.add(new LinkedList<>());
            loseAdj.add(new LinkedList<>());
        }

        for (int[] fight : results) {
            int winner = fight[0];
            int loser = fight[1];

            winAdj.get(winner).add(loser);
            loseAdj.get(loser).add(winner);
        }

        getRanks();

        return answer;
    }

    static void getRanks() {
        // 조건 : 한 노드에서 다른 노드로 이동 가능하면 해당 선수는 순위 선정이 가능

        for (int i = 1; i <= personCnt; i++) {
            boolean[] visited = new boolean[personCnt + 1];

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                Integer cur = q.poll();

                for (int next : winAdj.get(cur)) {
                    if (visited[next]) continue;

                    q.add(next);
                    visited[next] = true;
                }
            }

            q = new LinkedList<>();
            q.add(i);

            while(!q.isEmpty()) {
                Integer cur = q.poll();

                for (int next : loseAdj.get(cur)) {
                    if (visited[next]) continue;

                    q.add(next);
                    visited[next] = true;
                }
            }

            boolean flag = true;
            for (int j = 1; j <= personCnt; j++) {
                if(!visited[j]) flag = false;
            }

            if(flag) answer += 1;
        }
    }

    public static void main(String[] args) {
        graph_순위 sol = new graph_순위();

        long item = sol.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

        System.out.println(item);
    }
}
