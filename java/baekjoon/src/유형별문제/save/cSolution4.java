package 유형별문제.save;

import java.util.*;

public class cSolution4 {
    public static int longestChain(List<String> words) {
        // Write your code here
        HashMap<String, Integer> dict = new HashMap<>();

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int maxLen = 1;

        for (String word : words) {
            int subMaxLen = 1;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String extractedStr = sb.toString();
                if (dict.containsKey(extractedStr)) {
                    subMaxLen = Math.max(subMaxLen, dict.get(extractedStr) + 1);
                    maxLen = Math.max(maxLen, subMaxLen);
                }
            }
            dict.put(word, subMaxLen);
        }

        return maxLen;

    }

    public static void main(String[] args){
        LinkedList<String> words = new LinkedList<>();
        words.add("a");
        words.add("b");
        words.add("ba");
        words.add("bca");
        words.add("bada");
        words.add("basdsa");

        int result = cSolution4.longestChain(words);
        System.out.println(result);
    }
}
