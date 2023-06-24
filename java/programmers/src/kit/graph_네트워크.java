package kit;

import java.util.*;

class graph_네트워크 {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList();

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;

                if(computers[i][j] == 0) continue;
                adj.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            answer += 1;

            Queue<Integer> q = new LinkedList();
            q.add(i);
            visited[i] = true;

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int next : adj.get(cur)){
                    if(visited[next]) continue;

                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return answer;
    }
}