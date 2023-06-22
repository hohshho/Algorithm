package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class num2295 {
    static int N, res;
    static int[] list;
    static ArrayList<Integer> xy = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = stoi(br.readLine());
        }

        Arrays.sort(list);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                xy.add(list[i] + list[j]);
            }
        }
        Collections.sort(xy);

        for (int k = list.length - 1; k >= 0; k--) {
            for (int z = k; z >= 0; z--) {
                int partSum = list[k] - list[z];

                if (partSum <= 0) continue;

                int start = 0, end = xy.size() - 1;

                while (end >= start) {
                    int mid = (start + end) / 2;

                    if (partSum == xy.get(mid)) {
                        System.out.println(list[k]);
                        return;
                    }

                    if(partSum > xy.get(mid)) {
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }

                }

            }

        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
