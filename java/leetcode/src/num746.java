public class num746 {
    class Solution {
        public static int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length];

            dp[0] = cost[0];
            dp[1] = cost[1];

            for(int i=2; i<cost.length; i++){
                dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
            }

            return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
        }
    }

    public static void main(String[] args){
        System.out.println(Solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
