package 유형별문제.save;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class cSolution6 {
    static int INF = 98765321;
    static LinkedList<HashMap<Integer, Integer>> dist = new LinkedList<>();
    public static int minimumTreePath(int n, List<List<Integer>> edges, List<Integer> visitNodes) {
        for(int i = 0; i < n + 1; i++){
            dist.add(new HashMap<Integer, Integer>());
        }

        for (List<Integer> edge : edges) {
            int start = edge.get(0);
            int end = edge.get(1);

            dist.get(start).put(end, 1);
            dist.get(end).put(start, 1);
        }

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == j || j == k) continue;

                    if (!dist.get(i).containsKey(k) || !dist.get(k).containsKey(j)) continue;

                    int cur = dist.get(i).containsKey(j) ? dist.get(i).get(j) : INF;
                    dist.get(i).put(j, Math.min(cur, dist.get(i).get(k) + dist.get(k).get(j)));
                    dist.get(j).put(i, Math.min(cur, dist.get(i).get(k) + dist.get(k).get(j)));
                }
            }
        }

        int start = 1, end, partDistance = -1, min = INF;
        int sum = 0;

        for (int item : visitNodes) {
            end = item;

            if(!dist.get(start).containsKey(end)) return -1;

            sum += dist.get(start).get(end);

            start = end;
        }

        // 마지막 노드 처리
        end = n;

        if(!dist.get(start).containsKey(end)) return -1;

        sum += dist.get(start).get(end);

        return sum;
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

        int result = cSolution6.minimumTreePath(n, edges, visitNodes);

        System.out.println(result);
    }
}

