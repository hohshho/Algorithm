package kit;

import java.util.*;

public class dp_N으로표현 {
    static int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {



        return answer == Integer.MAX_VALUE || answer > 8 ? -1 : answer;
    }

    public static void main(String[] args) {
        dp_N으로표현 sol = new dp_N으로표현();

        int item = sol.solution(5, 12);
        System.out.println(item);
    }

}
