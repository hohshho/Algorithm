import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class level3_출퇴근길 {
    static int n, m;
    static int s, t;
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        dfs(s, t, graph, s1, new boolean[n + 1]);
        dfs(t, -1, reverseGraph, s2, new boolean[n + 1]);

        s1.retainAll(s2);

        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();
        dfs(t, s, graph, s3, new boolean[n + 1]);
        dfs(s, -1, reverseGraph, s4, new boolean[n + 1]);

        s3.retainAll(s4);

        s1.retainAll(s3);

        int answer = s1.size();

        if (s1.contains(s)) answer--;
        if (s1.contains(t)) answer--;

        System.out.println(answer);
    }

    public static void dfs(int node, int stop, List<List<Integer>> graph, Set<Integer> set, boolean[] visited) {
        if (stop != -1 && node == stop) {
            return;
        }

        for (int i = 0; i < graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);

            if (visited[next]) continue;

            visited[node] = true;
            set.add(next);
            dfs(next, stop, graph, set, visited);
        }

        return;

    }
}