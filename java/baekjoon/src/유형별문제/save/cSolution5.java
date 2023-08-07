package 유형별문제.save;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class cSolution5 {
    static List<int[]> visitList = new LinkedList();
    static LinkedList<LinkedList<Integer>> adj = new LinkedList();
    static int[] visitArr;
    static int visitLen, N;
    static int min = Integer.MAX_VALUE;

    public static int minimumTreePath(int n, List<List<Integer>> edges, List<Integer> visitNodes) {
        // Write your code here
        N = n;

        visitLen = visitNodes.size();

        visitArr = new int[visitLen];
        for (int i = 0; i < visitLen; i++) {
            visitArr[i] = visitNodes.get(i);
        }

        for (int i = 0; i <= N; i++) {
            adj.add(new LinkedList<>());
        }

        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        int start = 1, end, partDistance = -1;
        int sum = 0;

        for (int item : visitNodes) {
            end = item;
            partDistance = search(start, end);

            if (partDistance == -1) break;
            sum += partDistance;

            start = end;
        }

        if (partDistance == -1) return -1;

        // 마지막 노드 처리
        end = n;

        partDistance = search(start, end);

        if (partDistance == -1) return -1;

        sum += partDistance;

        min = Math.min(min, sum);

        return min;
    }

    public static void permutation(int cnt, int[] selected, boolean[] partVisited) {
        if (cnt == visitLen) {
            visitList.add(selected);
            return;
        }

        for (int i = 0; i < visitLen; i++) {
            if (partVisited[i]) continue;

            partVisited[i] = true;
            selected[cnt] = visitArr[i];
            permutation(cnt + 1, selected, partVisited);
            partVisited[i] = false;
        }
    }

    public static int search(int start, int end) {
        int result = -1;
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visit = new boolean[N + 1];
        visit[start] = true;
        q.add(start);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : adj.get(cur)) {
                    if (visit[next]) continue;

                    if (next == end) {
                        return depth;
                    }

                    q.add(next);
                    visit[next] = true;
                }
            }

            depth += 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int edgesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int edgesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, edgesRows).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int visitNodesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> visitNodes = IntStream.range(0, visitNodesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = cSolution5.minimumTreePath(n, edges, visitNodes);

        System.out.println(result);
    }
}
