package easy;

public class num704 {

    public static void main(String[] args) {
        int[] Input = {-1, 0, 3, 5, 9, 12};
        int target = 12;

        Solution sol = new Solution();

        System.out.println(sol.search(Input, target));

    }

    static class Solution {
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length, result = -1, mid;

            while (end >= start) {
                mid = (start + end) / 2;

                if(mid == nums.length){
                    break;
                }

                if (nums[mid] == target) {
                    result = mid;
                    break;
                }

                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return result;
        }
    }
}
