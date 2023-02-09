package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num4991 {
    static int X, Y, max, idx, res = Integer.MAX_VALUE;
    static char[][] map;
    static ArrayList<ArrayList<Node>> distance;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Node> list; // o * 저장 할 리스트
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] XY = br.readLine().split(" ");

            X = stoi(XY[0]);
            Y = stoi(XY[1]);

            // 종료 조건 0, 0
            if (X == 0 && Y == 0) {
                break;
            }

            // 연산에 필요한 변수 초기화
            map = new char[Y][X];
            max = 0;
            idx = 0;
            res = Integer.MAX_VALUE;
            list = new LinkedList<>();

            for (int i = 0; i < Y; i++) {
                map[i] = br.readLine().toCharArray().clone();

                for (int j = 0; j < X; j++) {
                    if (map[i][j] == 'o') {
                        idx++;
                        list.addFirst(new Node(idx, j, i));
                    }

                    if (map[i][j] == '*') {
                        idx++;
                        list.addLast(new Node(idx, j, i));
                    }
                }
            }

            distance = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                distance.add(new ArrayList<Node>());
            }

            // 1. 각 거리간 최소 거리 찾기
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int weight = searchDistance(i, j);
                    if (weight == -1) continue;
                    distance.get(i).add(new Node(j, weight));
                    distance.get(j).add(new Node(i, weight));
                }
            }

            // 2. 경우의 수 생성(순열)
            checked = new boolean[list.size()];
            checked[0] = true;
            permutation(0, 0, 0);

            System.out.println(res == Integer.MAX_VALUE ? -1 : res);
        }

        System.out.println(sb.toString());
    }

    static void permutation(int start, int depth, int sum) {
        if (depth == list.size() - 1) {
            res = Math.min(res, sum);
            return;
        }

        for(Node next : distance.get(start)) {
            if(checked[next.idx]) continue;
            checked[next.idx] = true;
            permutation(next.idx, depth + 1, sum + next.weight);
            checked[next.idx] = false;
        }
    }

    static int searchDistance(int startIdx, int endIdx) {
        Node startNode = list.get(startIdx);
        Node endNode = list.get(endIdx);

        visited = new boolean[Y][X];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startNode.x, startNode.y, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == endNode.x && cur.y == endNode.y) return cur.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y || visited[ny][nx] || map[ny][nx] == 'x')
                    continue;

                q.add(new Point(nx, ny, cur.cnt + 1));
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    static class Point {
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static class Node {
        int idx, x, y, weight;

        Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
