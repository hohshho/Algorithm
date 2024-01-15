package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num1389 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        dist = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }




    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
