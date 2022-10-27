package level34_위상정렬;

import java.io.*;
import java.util.*;

public class num3665 {
    static final int NONE = 0;
    static final int IMPOSSIBLE = 1;
    static final int NOT_DETERMINED = 2;

    static int T, N, M;
    static int[] indegree, result, prev;
    static Queue<Integer> q = new LinkedList<Integer>();
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = stoi(br.readLine());

        for(int i=0; i<T; i++){
            N = stoi(br.readLine());

            indegree = new int[N + 1];
            result = new int[N+1];
            prev = new int[N+1];
            graph = new int[N+1][N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) 
                prev[j] = stoi(st.nextToken());
            

            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    graph[prev[j]][prev[k]] = 1;
                    indegree[prev[k]]++;
                }
            }

            M = stoi(br.readLine());

            for (int j=0; j<M; j++) {

                st = new StringTokenizer(br.readLine());

                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());

                if (graph[a][b] == 1) {
                    graph[a][b] = 0;
                    graph[b][a] = 1;

                    indegree[a]++;
                    indegree[b]--;
                } else {
                	graph[a][b] = 1;
                    graph[b][a] = 0;
                    
                    indegree[b]++;
                    indegree[a]--;
                }
            }
            
            for (int j=1; j<=N; j++) {
                if (indegree[j] == 0) {
                    q.add(j);
                }
            }

            int ans = NONE;
            for (int j=1; j<=N; j++) {
                if (q.isEmpty()) {
                    ans = IMPOSSIBLE;
                    break;
                }
                if (q.size() > 1) {
                    ans = NOT_DETERMINED;
                    break;
                }

                int u = q.poll();
                result[j] = u;

                for (int k=1; k<=N; k++) {
                    if (graph[u][k] == 1) {
                        indegree[k]--;
                        if (indegree[k] == 0) q.add(k);
                    }
                }
            }
            
            if (ans == NONE) {
                for (int j=1; j<=N; j++)sb.append(result[j] + " ");
                sb.append("\n");
            } else if (ans == IMPOSSIBLE) sb.append("IMPOSSIBLE\n");
            else if (ans == NOT_DETERMINED) sb.append("?\n");
        }
        System.out.println(sb);
    }
    
    public static int stoi(String string) {
    	return Integer.parseInt(string);
    }
}