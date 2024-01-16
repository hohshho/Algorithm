import java.util.*;

public class num205 {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] sMapping = new int[129];
            int[] tMapping = new int[129];
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            for(int i=0; i < sArr.length; i++) {
                int sCur = sArr[i];
                int tCur = tArr[i];

                if(sMapping[sCur] == 0 && tMapping[tCur] == 0) {
                    sMapping[sCur] = tCur;
                    tMapping[tCur] = sCur;
                    continue;
                }

                if(sMapping[sCur] != tCur || tMapping[tCur] != sCur)
                    return false;
            }

            return true;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.isIsomorphic("paper", "title"));
    }
}
