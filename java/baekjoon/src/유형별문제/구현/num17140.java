package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 풀다 말았음
public class num17140 {
    // r : y, c : x
    static int r, c, k, INF = Integer.MAX_VALUE, res = INF;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        k = stoi(st.nextToken());

        for (int i = 0; i < 3; i++) {
            map.add(new ArrayList<Integer>());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                map.get(i).add(stoi(st.nextToken()));
            }
        }

        if (map.get(r - 1).get(c - 1) == k) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= 100; i++) {
            run(i);
            if (res != INF) break;
        }

        System.out.println(res == INF ? -1 : res);
    }

    public static void run(int depth) {
        ArrayList<ArrayList<Integer>> newMap = new ArrayList<>();
        // R
        if (map.get(0).size() <= map.size()) {
            int lineMaxSize = 0;

            for (ArrayList<Integer> line : map) {
                Collections.sort(line);
                ArrayList<Integer> newLine = new ArrayList<>();
                PriorityQueue<Node> pq = new PriorityQueue<Node>();
                int pre = 0;
                int preCnt = 0;

                for (int item : line) {
                    if (item == 0) continue;
                    // 초기
                    if (pre == 0) {
                        pre = item;
                        preCnt = 1;
                        continue;
                    }

                    if (pre == item) {
                        preCnt += 1;
                        continue;
                    }

                    pq.add(new Node(pre, preCnt));
                    pre = item;
                    preCnt = 1;
                }
                if(pre != 0) {
                    pq.add(new Node(pre, preCnt));
                }

                while (!pq.isEmpty()) {
                    Node cur = pq.poll();

                    newLine.add(cur.n);
                    if (newLine.size() >= 100) break;

                    newLine.add(cur.cnt);
                    if (newLine.size() >= 100) break;
                }

                int curSize = newLine.size();
                lineMaxSize = Math.max(lineMaxSize, curSize);
                newMap.add(newLine);
            }

            // 0추가
            for (ArrayList<Integer> line : newMap) {
                if (line.size() == lineMaxSize) continue;

                for (int i = line.size(); i < lineMaxSize; i++) {
                    line.add(0);
                }
            }
        }
        // C
        else {
            // i : x
            for (int i = 0; i < map.get(0).size(); i++) {
                PriorityQueue<Node> pq = new PriorityQueue<Node>();
                int pre = 0;
                int preCnt = 0;
                ArrayList<Integer> sero = new ArrayList<>();

                // j : y
                for (int j = 0; j < map.size(); j++) {
                    int item = map.get(j).get(i);

                    if (item == 0) continue;
                    sero.add(item);
                }

                Collections.sort(sero);
                for (int item : sero) {
                    if (pre == 0) {
                        pre = item;
                        preCnt = 1;
                        continue;
                    }

                    if (pre == item) {
                        preCnt += 1;
                        continue;
                    }

                    pq.add(new Node(pre, preCnt));
                    pre = item;
                    preCnt = 1;
                }

                pq.add(new Node(pre, preCnt));

                int curSize = 0;
                int index = 0;
                while (!pq.isEmpty()) {
                    Node cur = pq.poll();
                    curSize += 2;

                    if (newMap.size() < curSize) {
                        for (int j = 0; j < 2; j++) {
                            newMap.add(new ArrayList<>());

                            for (int k = 0; k < i; k++) {
                                newMap.get(index + j).add(0);
                            }
                        }
                    }

                    newMap.get(index).add(cur.n);
                    index += 1;
                    newMap.get(index).add(cur.cnt);
                    index += 1;

                    if (curSize == 100) break;
                }
            }

            // 0추가
            for (ArrayList<Integer> line : newMap) {
                if (line.size() == map.get(0).size()) continue;

                for (int i = line.size(); i < map.get(0).size(); i++) {
                    line.add(0);
                }
            }
        }
        map = newMap;

        if (map.size() >= r && map.get(0).size() >= c && map.get(r - 1).get(c - 1) == k) {
            res = depth;
            return;
        }
    }

    static class Node implements Comparable<Node> {
        int n, cnt;

        Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt != o.cnt) return this.cnt - o.cnt;
            return this.n - o.n;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
