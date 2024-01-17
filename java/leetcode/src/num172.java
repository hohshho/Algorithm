public class num172 {

    static class Solution {
        public int trailingZeroes(int n) {
            if(n == 0) return 0;

            long result = factorial(n);

            String[] resultArr = Long.toString(result).split("");

            int cnt = 0;
            for(int i = resultArr.length - 1; i >= 0; i--) {
                if(resultArr[i].equals("0")) cnt += 1;
                else break;
            }
            return cnt;
        }

        public long factorial(long n) {
            if(n == 1) return (long) 1;

            return (long) n * factorial(n - 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.trailingZeroes(10));
    }
}
