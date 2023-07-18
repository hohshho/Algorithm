package kit;

import java.util.*;

public class binarySearch_입국심사 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = Long.MAX_VALUE;

        long start = times[0];
        long end = (long) times[times.length - 1] * (long) n;

        while(start <= end){
            long mid = (start + end) / 2;

            if(checkTime(n, times, mid)) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
            else {
                start = mid + 1;
            }
        }

        return answer;
    }

    public static boolean checkTime(int n, int[] times, long limit){
        long check = 0;

        for(int time : times){
            check += limit / time;
        }

        return check >= n ? true : false;
    }

    public static void main(String[] args) {
        binarySearch_입국심사 sol = new binarySearch_입국심사();

        long item = sol.solution(1, new int[]{1000000000});

        System.out.println(item);
    }
}
