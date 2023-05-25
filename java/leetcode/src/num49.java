import java.util.*;

public class num49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap();
            List<List<String>> res = new ArrayList();

            for(String item : strs){
                char[] itemArr = item.toCharArray();
                Arrays.sort(itemArr);
                String key = new String(itemArr);

                ArrayList<String> set;
                if(map.containsKey(key)) {
                    set = map.get(key);
                }else {
                    set = new ArrayList();
                }
                set.add(item);
                map.put(key, set);
            }

            for(List<String> list : map.values()) {
                res.add(list);
            }

            return res;
        }
    }
}
