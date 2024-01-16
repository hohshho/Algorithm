import java.util.*;

public class num383 {
    static class Solution {
        // XXX: 다음부턴 이런 단순 hashMap은 배열로 저장 할 생각 하자
        public boolean canConstruct2(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) return false;
            int[] alphabets_counter = new int[26];

            for (char c : magazine.toCharArray())
                alphabets_counter[c-'a']++;

            for (char c : ransomNote.toCharArray()){
                if (alphabets_counter[c-'a'] == 0) return false;
                alphabets_counter[c-'a']--;
            }
            return true;
        }

        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<String, Integer> map = new HashMap();

            for(String cur : magazine.split("")) {
                int cnt = 1;
                if(map.containsKey(cur)) {
                    int curCnt = map.get(cur);
                    map.remove(cur);
                    cnt = curCnt + 1;
                }

                map.put(cur, cnt);
            }

            for(String cur : ransomNote.split("")) {
                if(map.containsKey(cur)) {
                    int curCnt = map.get(cur) - 1;
                    map.remove(cur);

                    if(curCnt != 0) map.put(cur, curCnt);
                }
                else {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.canConstruct("a", "b"));
    }
}
