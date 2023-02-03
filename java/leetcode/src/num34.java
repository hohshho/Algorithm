public class num34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{findFirstIndex(nums, target), findLastIndex(nums, target)};
        }

        private int findFirstIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    right = mid - 1;
                }
                else if (target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            return ans;
        }

        private int findLastIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    left = mid + 1;
                }
                else if (target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args){

    }
}
