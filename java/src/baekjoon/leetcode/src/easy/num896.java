package easy;

public class num896 {
    public static void main(String[] args) {
        int[] Input = {1,1,2};

        Solution sol = new Solution();

        System.out.println(sol.isMonotonic(Input));

    }

    static class Solution {
        public boolean isMonotonic(int[] nums) {
            Boolean result = true;
            int prevNum = nums[0];
            boolean index = nums[0] < nums[nums.length-1] ? true : false;

            for(int i=1; i<nums.length; i++ ){
                if(index) {
                    if(prevNum > nums[i]) {
                        result = false;
                        break;
                    }
                }else{
                    if(prevNum < nums[i]) {
                        result = false;
                        break;
                    }
                }
                prevNum = nums[i];
            }
            return result;
        }
    }
}
