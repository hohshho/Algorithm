package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class num1507 {
    static int N, INF = 987654321;
    static ArrayList<HashMap<Integer, Integer>> adj = new ArrayList<>();
    static int[][] dist, dist2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dist = new int[N][N];
        dist2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            adj.add(new HashMap<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int weight = stoi(st.nextToken());

                dist[i][j] = weight;
                dist2[i][j] = weight;
                adj.get(i).put(j, weight);
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (i == k || k == j) continue;

                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        if (adj.get(i).containsKey(j)) {
                            adj.get(i).remove(j);
                        }
                        dist2[i][j] = INF;
                    }
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == k || k == j) continue;

                    if (adj.get(i).containsKey(k) && adj.get(k).containsKey(j)) {
                        if (dist2[i][j] >= adj.get(i).get(k) + adj.get(k).get(j)) {
                            dist2[i][j] = adj.get(i).get(k) + adj.get(k).get(j);
                        }
                    }

                    if (dist2[i][j] >= dist2[i][k] + dist2[k][j]) {
                        dist2[i][j] = dist2[i][k] + dist2[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dist[i][j] != dist2[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 동일하면 값 출력
        int res = 0;
        for (HashMap<Integer, Integer> list : adj) {
            for (int weight : list.values()) {
                res += weight;
            }
        }
        System.out.println(res / 2);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
