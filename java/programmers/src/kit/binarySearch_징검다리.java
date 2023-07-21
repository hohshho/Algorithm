package kit;

import java.util.*;

public class binarySearch_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0, right = distance;

        Arrays.sort(rocks);
        while (left <= right) {
            int mid = (left + right) / 2;
            int removeRocks = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid)
                    removeRocks++;
                else
                    prev = rocks[i];
            }

            if (distance - prev < mid) removeRocks++;

            if (removeRocks > n) {
                right = mid - 1;
                continue;
            }

            answer = Math.max(mid, answer);
            left = mid + 1;
        }

        return answer;
    }


    public static void main(String[] args) {
        binarySearch_징검다리 sol = new binarySearch_징검다리();

        long item = sol.solution(25, new int[]{2, 14, 11, 21, 17}, 2);

        System.out.println(item);
    }

}
