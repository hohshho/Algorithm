package kit;

import java.util.*;

public class 모음사전 {
    static char[] possibleWords = new char[]{'A', 'E', 'I', 'O', 'U'};
    static int num = 1;
    static HashMap<String, Integer> map = new HashMap<>();

    public int solution(String word) {
        int answer = 0;

        makeMap(0, "");

        return map.get(word);
    }

    public void makeMap(int cnt, String word) {
        if(cnt == 5) {
            return;
        }

        for(int i=0; i<5; i++){
            word += possibleWords[i];
            map.put(word, num);
            num += 1;
            makeMap(cnt + 1, word);
            word = word.substring(0, word.length() - 1);
        }
    }
}
