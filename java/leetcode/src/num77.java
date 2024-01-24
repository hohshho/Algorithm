import java.util.*;

public class num77 {
    class Solution {
        List<List<Integer>> result = new LinkedList();

        public List<List<Integer>> combine(int n, int k) {
            combinations(0, 0, n, new int[k]);
            return result;
        }

        public void combinations(int idx, int cnt, int n, int[] selected) {
            if(selected.length == cnt) {
                LinkedList<Integer> part = new LinkedList<>();
                for(int select : selected) {
                    part.add(select);
                }
                result.add(part);
                return;
            }

            for(int i = idx; i < n; i++){
                selected[cnt] = i + 1;
                combinations(i + 1, cnt + 1, n, selected);
            }
        }
    }
}
