import java.util.*;

public class num17 {
    class Solution {
        LinkedList<Character>[] buttons= new LinkedList[10];
        LinkedList<String> result = new LinkedList<>();
        int maxDepth;

        public List<String> letterCombinations(String digits) {
            if(digits.equals("")) return result;

            makeButtons();

            maxDepth = digits.length();

            search(0, "", digits.split(""));

            return result;
        }

        public void search(int depth, String cur, String[] digits) {
            if(maxDepth == depth) {
                result.add(cur);
                return;
            }

            int pushNum = Integer.parseInt(digits[depth]);

            for(int i=0; i<buttons[pushNum].size(); i++) {
                search(depth + 1, cur + buttons[pushNum].get(i), digits);
            }
        }

        public void makeButtons() {
            for(int i=0; i<10; i++){
                buttons[i] = new LinkedList<>();
            }

            char item = 'a' - 1;
            for(int i=2; i<10; i++){
                int itemCnt = i == 9 || i == 7 ? 4 : 3;

                for(int j=0; j<itemCnt; j++) {
                    item += 1;
                    buttons[i].add(item);
                }
            }
        }
    }
}
