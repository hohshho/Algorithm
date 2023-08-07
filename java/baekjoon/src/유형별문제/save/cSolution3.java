package 유형별문제.save;

import java.util.*;

public class cSolution3 {
    public static int maxLength(List<Integer> a, int k) {
        // Write your code here
        int listLen = a.size();
        int maxLen = 0;

        for(int i=0; i < listLen; i++){
            long sum = 0;

            for(int j = i; j < listLen; j++) {
                sum += a.get(j);

                if(sum > k) break;

                maxLen = Math.max(maxLen, j - i + 1);
            }

            if(maxLen > listLen - i) break;
        }

        return maxLen;
    }


    public static void main(String[] args){
        List<Integer> list = new LinkedList<Integer>();
        for(int i=1; i<= 3; i++){
            list.add(i);
        }

        System.out.println(new cSolution3().maxLength(list, 4));
    }
}
