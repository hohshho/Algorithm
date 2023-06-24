package kit;

import java.util.*;

class graph1_가장먼노드 {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList();
    static int res = 0, INF = Integer.MAX_VALUE, max = 0;

    public int solution(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int start = edge[0] - 1;
            int end = edge[1] - 1;

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[n];
        int size = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        dist[0] = 0;
        visited[0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int next : adj.get(cur.e)) {
                if (visited[next]) continue;

                dist[next] = cur.cnt + 1;
                q.add(new Node(next, cur.cnt + 1));
                visited[next] = true;

                if (max < cur.cnt + 1) {
                    max = cur.cnt + 1;
                    res = 0;
                }

                res += 1;
            }
        }

        return res;
    }

    static class Node {
        int e, cnt;

        Node(int e, int cnt) {
            this.e = e;
            this.cnt = cnt;
        }
    }
}