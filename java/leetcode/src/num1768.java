public class num1768 {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();

            int len1 = word1.length();
            int len2 = word2.length();
            int maxLen = len1 > len2 ? len1 : len2;
            int minLen = len1 < len2 ? len1 : len2;

            for(int i=0; i < minLen; i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }

            String add = "";
            if(minLen != maxLen) add = len1 > len2 ? word1.substring(minLen) : word2.substring(minLen);
            sb.append(add);

            return sb.toString();
        }
    }
}
