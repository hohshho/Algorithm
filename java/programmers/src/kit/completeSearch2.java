package kit;

import java.util.*;

class completeSearch2 {
    static HashMap<Integer, HashSet<Integer>> adj;
    static int res = Integer.MAX_VALUE, wiresLen;
    static int N;

    public int solution(int n, int[][] wires) {
        N = n;

        if(n == 2) return Math.abs(wires[0][0] - wires[0][1]);

        adj = new HashMap<>();
        for(int i=0; i <= n; i++){
            adj.put(i, new HashSet<Integer>());
        }

        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        wiresLen = wires.length;

        for(int i = 0; i<wiresLen; i++){
            int[] remove = wires[i];
            int start = remove[0];
            int end = remove[1];

            adj.get(start).remove(end);
            adj.get(end).remove(start);
            check(adj, start, end);
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        return res;
    }

    public static void check(HashMap<Integer, HashSet<Integer>> partAdj, int start, int end){
        int p1 = 0, p2 = 0;

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList();
        q.add(start);
        while(!q.isEmpty()){
            Integer cur = q.poll();

            if(partAdj.get(cur).size() == 0) {
                p1 = 1;
                break;
            }

            for(Integer next : partAdj.get(cur)){
                if(visited[next]) continue;

                visited[next] = true;
                q.add(next);
                p1 += 1;
            }
        }

        q = new LinkedList();
        q.add(end);
        while(!q.isEmpty()){
            Integer cur = q.poll();

            if(partAdj.get(cur).size() == 0) {
                p2 = 1;
                break;
            }

            for(Integer next : partAdj.get(cur)){
                if(visited[next]) continue;

                visited[next] = true;
                q.add(next);
                p2 += 1;
            }
        }

        int diff = Math.abs(p1 - p2);
        res = Math.min(diff, res);

        return;
    }
}