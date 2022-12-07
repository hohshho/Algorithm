package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num21608 {
    static int N, studentLen, res = 0;
    static Student students[];
    static HashMap<Integer, HashSet> hashMap = new HashMap<>();
    static int[][] resultMap;       // 최종 결과 저장
    static int[][] checkValueMap;   //
    static int[] dx = new int[]{1, -1, 0, 0}, dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        studentLen = N * N;
        students = new Student[studentLen];

        resultMap = new int[N][N];

        for (int i = 0; i < studentLen; i++) {
            HashMap<Integer, HashSet<Integer>> student = new HashMap<Integer, HashSet<Integer>>();

            String[] input = br.readLine().split(" ");

            HashSet<Integer> favoriteFriend = new HashSet<>();

            for (int j = 1; j < input.length; j++) {
                favoriteFriend.add(stoi(input[j]));
            }

            students[i] = new Student(stoi(input[0]), favoriteFriend);
            hashMap.put(stoi(input[0]) , favoriteFriend);
        }

        for (int i = 0; i < studentLen; i++) {
            // 하나씩 넣음
            searchStudentPosition(i);
        }

        calcResult();

        // 결과
        System.out.println(res);

    }

    public static void searchStudentPosition(int idx) {
        checkValueMap = new int[N][N];
        Student student = students[idx];
        PriorityQueue<Point> possiblePoint = new PriorityQueue<>();
        int max = 0;

        // 조건 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        for (int i = 0; i < studentLen; i++) {
            int x = i / N, y = i % N, cx, cy;
            int blankCount = 0;

            // 현재 앉은 자리 있으면 pass
            if (resultMap[x][y] != 0) {
                continue;
            }

            for (int j = 0; j < 4; j++) {
                cx = dx[j] + x;
                cy = dy[j] + y;

                if (checkMapRange(cx, cy)) {
                    // 현재 좌표가 좋아하는 친구인지
                    if (student.favoriteList.contains(resultMap[cx][cy])) {
                        checkValueMap[x][y] += 1;
                    }

                    if(resultMap[cx][cy] == 0) {
                        blankCount++;
                    }
                }
            }

            if (checkValueMap[x][y] > max) {
                max = checkValueMap[x][y];

                // 선택 가능한 좌표 리스트 초기화
                possiblePoint.clear();
                possiblePoint.add(new Point(x, y, blankCount, checkValueMap[x][y]));

            } else if (checkValueMap[x][y] == max) {
                possiblePoint.add(new Point(x, y, blankCount, checkValueMap[x][y]));
                continue;
            }
        }

        Point selected = possiblePoint.remove();
        resultMap[selected.x][selected.y] = student.num;

    }

    public static void calcResult() {
        for (int i = 0; i < studentLen; i++) {
            int x = i / N, y = i % N, cx, cy;
            int count = 0;
            HashSet map = hashMap.get(resultMap[x][y]);

            for (int j = 0; j < 4; j++) {
                cx = dx[j] + x;
                cy = dy[j] + y;

                if (checkMapRange(cx, cy) && map.contains(resultMap[cx][cy])) {
                    count++;
                }
            }

            if(count == 1) {
                res += 1;
            } else if (count == 2) {
                res += 10;
            } else if (count == 3) {
                res += 100;
            } else if (count == 4) {
                res += 1000;
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x, y, blank, like;

        Point(int x, int y, int blank, int like) {
            this.x = x;
            this.y = y;
            this.blank = blank;
            this.like = like;
        }

        public int compareTo(Point o) {
            // like 많은 순 -> blank 많은 순 -> y 작은 순 -> x 작은 순
            if (this.like != o.like) {
                return o.like - this.like;
            }
            if (this.blank != o.blank) {
                return o.blank - this.blank;
            }
            if (this.y != o.y) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    static class Student {
        int num;
        HashSet<Integer> favoriteList;

        Student(int n, HashSet list) {
            this.num = n;
            this.favoriteList = list;
        }
    }

    public static boolean checkMapRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

