import java.util.*;

public class num1431 {
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> result = new LinkedList<>();

            int max = 0;
            for(int candyCnt : candies) {
                max = max > candyCnt ? max : candyCnt;
            }

            for(int i=0; i < candies.length; i++) {
                int candyCnt = candies[i];

                result.add(candies[i] + extraCandies >= max ? true : false);
            }

            return result;
        }
    }
}
