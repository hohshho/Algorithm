import java.util.*;

public class num1207 {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();

            for(int cur : arr){
                if(!map.containsKey(cur)) {
                    map.put(cur, 1);
                    continue;
                }

                int cnt = map.get(cur);
                map.remove(cur);
                map.put(cur, cnt + 1);
            }

            for(int key : map.keySet()) {
                int value = map.get(key);
                if(set.contains(value)) return false;
                else set.add(value);
            }
            return true;
        }
    }
}
