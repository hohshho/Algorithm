public class num1732 {
    class Solution {
        public int largestAltitude(int[] gain) {
            int result = 0;
            int[] sum = new int[gain.length + 1];
            for(int i=1; i<=gain.length; i++){
                sum[i] = sum[i-1] + gain[i-1];
                result = Math.max(result, sum[i]);
            }
            return result;
        }
    }
}
