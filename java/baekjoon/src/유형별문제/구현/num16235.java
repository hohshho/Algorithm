package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num16235 {
    static int N, M, K;
    static Machine S2D2;
    static int[][] map;
    static PriorityQueue<Tree>[][] treeMap;
    static LinkedList<Tree> treeList = new LinkedList<>();
    static LinkedList<Tree> fallList = new LinkedList<>();
    static int res;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        treeMap = new PriorityQueue[N][N];
        S2D2 = new Machine(N);
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                S2D2.addNutrientData(i, j, stoi(st.nextToken()));
                map[i][j] = 5;
                treeMap[i][j] = new PriorityQueue<>();
            }
        }

        res = M;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = stoi(st.nextToken()) - 1;
            int y = stoi(st.nextToken()) - 1;
            int age = stoi(st.nextToken());

            treeMap[y][x].add(new Tree(x, y, age));

            treeList.add(new Tree(x, y, age));
        }

        for (int i = 0; i < K; i++) {
            fallList = new LinkedList<>();
            LinkedList<Tree> newTreeList = new LinkedList<>();
            visited = new boolean[N][N];
            int cnt = 0;

            // 봄, 여름
            for (Tree tree : treeList) {
                int x = tree.x;
                int y = tree.y;

                if (visited[y][x]) continue;
                visited[y][x] = true;

                PriorityQueue<Tree> newTree = new PriorityQueue<>();
                PriorityQueue<Tree> preTree = treeMap[y][x];
                int addSum = 0;

                while (!preTree.isEmpty()) {
                    Tree cur = preTree.poll();

                    if (map[y][x] < cur.age) {
                        addSum += cur.age / 2;
                        continue;
                    }

                    map[y][x] -= cur.age;
                    newTree.add(new Tree(x, y, cur.age + 1));

                    if ((cur.age + 1) % 5 == 0) {
                        fallList.add(new Tree(x, y, 1));
                    }

                    cnt += 1;
                }

                // 봄
                treeMap[y][x] = newTree;

                // 여름
                map[y][x] += addSum;

                newTreeList.add(new Tree(x, y, 0));
            }

            // 가을
            for (Tree cur : fallList) {
                int x = cur.x;
                int y = cur.y;

                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (!checkMapValue(nx, ny)) continue;

                    treeMap[ny][nx].add(new Tree(nx, ny, 1));

                    cnt += 1;
                    newTreeList.add(new Tree(nx, ny, 0));
                }

            }

            // 겨울
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[j][k] += S2D2.getNutrientData(k, j);
                }
            }

            res = cnt;
            treeList = newTreeList;
        }

        System.out.println(res);
    }

    public static boolean checkMapValue(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Machine {
        int[][] nutrientMap;

        Machine(int N) {
            nutrientMap = new int[N][N];
        }

        void addNutrientData(int x, int y, int input) {
            this.nutrientMap[y][x] = input;
        }

        int getNutrientData(int x, int y) {
            return this.nutrientMap[y][x];
        }
    }

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
