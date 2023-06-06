package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num17471 {
    static int N, res = Integer.MAX_VALUE;
    static int[] persons;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        persons = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            persons[i] = stoi(st.nextToken());
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int M = stoi(st.nextToken());

            for (int j = 0; j < M; j++) {
                int e = stoi(st.nextToken()) - 1;
                adj.get(i).add(e);
            }
        }

        for (int i = 1; i < (N / 2) + 1; i++) {
            combination1(0, 0, i, new int[i]);
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static void combination1(int idx, int cnt, int size, int[] selected) {
        if (cnt == size) {
            int[] selected2 = new int[N - size];
            int index = 0;
            for (int i = 0; i < N; i++) {
                if(visited[i]) continue;
                selected2[index++] = i;
            }

            getPersonDiff(selected, selected2);
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            selected[cnt] = i;
            combination1(i + 1, cnt + 1, size, selected);
            visited[i] = false;
        }
    }

    public static void getPersonDiff(int[] selected1, int[] selected2) {
        int cnt1 = 1, cnt2 = 1, sum1 = 0, sum2 = 0;
        int selected1Size = selected1.length, selected2Size = selected2.length;
        boolean[] selectVisited = new boolean[N];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int item : selected1) {
            set1.add(item);
            sum1 += persons[item];
        }

        for (int item : selected2) {
            set2.add(item);
            sum2 += persons[item];
        }

        // 첫번쨰
        Queue<Integer> q = new LinkedList<>();
        q.add(selected1[0]);
        selectVisited[selected1[0]] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int e : adj.get(cur)) {
                if(set1.contains(e) && !selectVisited[e]) {
                    selectVisited[e] = true;
                    q.add(e);
                    cnt1++;
                }
            }
        }

        if (cnt1 < selected1Size) return;

        // 2번째
        q = new LinkedList<>();
        q.add(selected2[0]);
        selectVisited = new boolean[N];
        selectVisited[selected2[0]] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int e : adj.get(cur)) {
                if(set2.contains(e) && !selectVisited[e]) {
                    selectVisited[e] = true;
                    q.add(e);
                    cnt2++;
                }
            }
        }

        if (cnt2 < selected2Size) return;
        res = Math.min(res, Math.abs(sum1 - sum2));
        return;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
