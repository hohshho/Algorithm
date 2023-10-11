package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num17140 {
    static int r, c, k, INF = Integer.MAX_VALUE, result = INF;
    static LinkedList<LinkedList<Integer>> A = new LinkedList<LinkedList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = stoi(st.nextToken()); // 행
        c = stoi(st.nextToken()); // 열
        k = stoi(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            A.add(new LinkedList<>());

            for (int j = 0; j < 3; j++) {
                A.get(i).add(stoi(st.nextToken()));
            }
        }

        for (int i = 0; i <= 100; i++) {
            // A값 확인
            if (A.size() >= r && A.get(0).size() >= c) {
                if(A.get(r - 1).get(c - 1) == k) {
                    result = i;
                    break;
                }
            }

            // R연산
            if (A.size() >= A.get(0).size()) {
                R();
            }
            // C 연산
            else {
                C();
            }
        }

        System.out.println(result == INF ? -1 : result);
    }

    public static void R() {
        LinkedList<HashMap<Integer, Integer>> mapList = new LinkedList<HashMap<Integer, Integer>>();

        for (int i = 0; i < A.size(); i++) { // 열
            mapList.add(new HashMap<>());

            for (int j = 0; j < A.get(i).size(); j++) { // 행
                int temp = A.get(i).get(j);

                if(temp == 0) continue;

                if (!mapList.get(i).containsKey(temp)) {
                    mapList.get(i).put(temp, 1);
                } else {
                    mapList.get(i).put(temp, mapList.get(i).get(temp) + 1);
                }
            }
        }

        ACopy(mapList, 'r');
    }

    public static void C() {
        // 열을 행으로 변환해서 map으로 넘겨준다.
        LinkedList<HashMap<Integer, Integer>> mapList = new LinkedList<HashMap<Integer, Integer>>();

        // 미리 열개수만큼 만들어 줌
        for(int i=0; i<A.get(0).size(); i++){
            mapList.add(new HashMap<>());
        }

        for (int i = 0; i < A.size(); i++) { // 행
            for (int j = 0; j < A.get(0).size(); j++) { // 열
                int temp = A.get(i).get(j);

                if(temp == 0) continue;

                if (!mapList.get(j).containsKey(temp)) {
                    mapList.get(j).put(temp, 1);
                } else {
                    mapList.get(j).put(temp, mapList.get(j).get(temp) + 1);
                }

            }
        }

        ACopy(mapList, 'c');
    }

    public static void ACopy(LinkedList<HashMap<Integer, Integer>> mapList, char action) {
        A = new LinkedList<>();

        int maxLine = 0;

        for (int i = 0; i < mapList.size(); i++) {
            PriorityQueue<Point> PointList = new PriorityQueue<>();
            LinkedList<Integer> list = new LinkedList<>();

            for (int key : mapList.get(i).keySet()) {
                PointList.add(new Point(key, mapList.get(i).get(key)));
            }

            int lineCnt = 0;
            while (!PointList.isEmpty()) {
                lineCnt += 2;
                Point cur = PointList.poll();

                if(lineCnt > 100) break;

                list.add(cur.n);
                list.add(cur.cnt);

                maxLine = Math.max(maxLine, lineCnt);
            }

            A.add(list);
        }

        // 최대 열 개수대로 0추가
        for (int i = 0; i < A.size(); i++) {
            int curSize = A.get(i).size();

            if (curSize == maxLine) continue;

            while (curSize != maxLine) {
                curSize += 2;

                A.get(i).add(0);
                A.get(i).add(0);
            }
        }

        if (action == 'c') {
            // c일 경우 만들어준 A를 행 <-> 열 변경한다.
            LinkedList<LinkedList<Integer>> temp = new LinkedList<LinkedList<Integer>>();

            for (int i = 0; i < A.get(0).size(); i++) {
                temp.add(new LinkedList<>());
            }

            for (int i = 0; i < A.size(); i++) { // 행
                for (int j = 0; j < temp.size(); j++) { // 열
                    temp.get(j).add(A.get(i).get(j));
                }
            }

            A = temp;
        }

    }

    public static class Point implements Comparable<Point> {
        int n, cnt;

        Point(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            // TODO: 풀고 맞으면, 이런거 이렇게 풀어야함
            if (this.cnt == 0) {
                return 1;
            }

            if (o.cnt == 0) {
                return 0;
            }

            if (this.cnt != o.cnt) {
                return this.cnt - o.cnt;
            }

            return this.n - o.n;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
