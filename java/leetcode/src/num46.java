import java.util.*;

public class num46 {
    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            visited = new boolean[nums.length];

            permutations(0, new int[nums.length], nums);
            return result;
        }

        public void permutations(int cnt, int[] selected, int[] nums){
            if(cnt == nums.length) {
                LinkedList<Integer> part = new LinkedList<>();

                for(int num : selected){
                    part.add(num);
                }

                result.add(part);

                return;
            }

            for(int i=0; i<nums.length; i++){
                if(visited[i]) continue;

                visited[i] = true;
                selected[cnt] = nums[i];
                permutations(cnt + 1, selected, nums);
                visited[i] = false;
            }
        }
    }
}
