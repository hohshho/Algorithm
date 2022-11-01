package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class example {
    static int arr[], n, r, totalCnt;
    static boolean visited[];
    static ArrayList<int[]> res;

    static String[] commands = {
            "permutation", "rePermutation", "combination", "reCombination"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nr = br.readLine().split(" ");

        n = stoi(nr[0]);
        r = stoi(nr[1]);
        arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(input[i]);
        }

        for (String command : commands) {
            run(command);
        }
    }

    public static void run(String command) {
        init();

        switch (command) {
            case "permutation":
                permutation(0, new int[r]);
                break;
            case "rePermutation":
                rePermutation(0, new int[r]);
                break;
            case "combination":
                combination(0, 0, new int[r]);
                break;
            case "reCombination":
                reCombination(0, 0, new int[r]);
                break;
        }

        printResult(command);
    }

    public static void init() {
        totalCnt = 0;
        res = new ArrayList<>();
        visited = new boolean[n];
    }

    // static int arr[], n, r, totalCnt / ArrayList<int[]> res; / boolean[] visited
    public static void permutation(int cnt, int[] selected) {
        if (cnt == r) {
            totalCnt++;

            int[] saveArr = selected.clone();
            res.add(saveArr);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            selected[cnt] = arr[i];
            permutation(cnt + 1, selected);
            visited[i] = false;
        }
    }

    // static int arr[], n, r, totalCnt / ArrayList<int[]> res; / boolean[] visited
    public static void rePermutation(int cnt, int[] selected) {
        if (cnt == r) {
            totalCnt++;

            int[] saveArr = selected.clone();
            res.add(saveArr);

            return;
        }

        for (int i = 0; i < n; i++) {
            selected[cnt] = arr[i];
            rePermutation(cnt + 1, selected);
        }
    }

    // static int arr[], n, r, totalCnt / ArrayList<int[]> res;
    public static void combination(int idx, int cnt, int[] selected) {
        if (cnt == r) {
            totalCnt++;

            int[] saveArr = selected.clone(); // 객체 복사 - 원본 배열과 별개의 주소값으로 새로운 객체 생성
            res.add(saveArr);

            return;
        }

        for (int i = idx; i < n; i++) {
            selected[cnt] = arr[i];
            combination(i + 1, cnt + 1, selected);
        }
    }

    // static int arr[], n, r, totalCnt / ArrayList<int[]> res;
    public static void reCombination(int idx, int cnt, int[] selected) {
        if (cnt == r) {
            totalCnt++;

            int[] saveArr = selected.clone(); // 객체 복사 - 원본 배열과 별개의 주소값으로 새로운 객체 생성
            res.add(saveArr);

            return;
        }

        for (int i = idx; i < n; i++) {
            selected[cnt] = arr[i];
            reCombination(i, cnt + 1, selected);
        }
    }

    public static void printResult(String command) {
        System.out.print(command);

        System.out.print("( ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println(")");
        System.out.println("n : " + n + " , r : " + r);
        System.out.println("totalCount : " + totalCnt);

        for (int[] list : res) {
            for (int item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
