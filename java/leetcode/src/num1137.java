public class num1137 {
    public static void main(String[] args){
        System.out.println(new Solution().tribonacci(25));
    }

    static class Solution{
        public int tribonacci(int n){
            int dp[] = new int[n + 1];
            if(n<=2) {
                if(n==0) return 0;
                return 1;
            }
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for(int i=3; i < n+1; i++){
                dp[i] = dp[i - 1] + dp[i-2] + dp[i-3];
            }

            return dp[n];
        }
    }
}
