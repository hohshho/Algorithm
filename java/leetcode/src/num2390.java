import java.util.*;

public class num2390 {
    static class Solution {
        public String removeStars(String s) {
            String result = "";

            // for(char part : s.toCharArray()) {
            //     if(part == '*' && result.equals("")) continue;

            //     if(part == '*') result = result.substring(0, result.length() - 1);
            //     else result += part;
            // }

            Stack<Character> stack = new Stack<>();

            for(char part : s.toCharArray()){
                if(part == '*' && stack.isEmpty()) continue;

                if(part == '*') stack.pop();
                else stack.push(part);
            }

            while(!stack.isEmpty()){
                result = stack.pop() + result;
            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        solution.removeStars("leet**cod*e");
    }
}
