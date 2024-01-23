import java.util.*;

public class num215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int cur : nums){
                pq.add(cur);
            }
            int result = 0;
            for(int i=0; i<k; i++){
                result = pq.poll();
            }
            return result;
        }
    }
}
