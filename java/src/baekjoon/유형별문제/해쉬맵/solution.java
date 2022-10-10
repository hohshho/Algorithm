package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Pattern;

public class solution {
    public static String solution() {
        String[] registered_list = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String new_id = "cow";

        String answer = "";

        // 1.
//        if(!Arrays.asList(registered_list).contains(new_id)) {
//            return new_id;
//        }

        // TODO: 잘못된 값 필요하면 여기서

        // 2.
        String newS = new_id.replaceAll("[0-9]","");
        String newN = new_id.replaceAll("[^0-9]","");

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(String item : registered_list) {
            if(item.contains(newS)){
                String itemNum = item.replaceAll("[^0-9]","");

                if(itemNum.length() != 0) {
                    list.add(Integer.parseInt(itemNum));
                }
            }
        }

        Collections.sort(list);

        int index = list.get(0);
        for(int i=1; i<list.size(); i++){
            if(list.get(i) != index + 1) {
                answer = newS + (index + 1);
                break;
            }

            index++;
        }


        return answer;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args){
        solution();

    }
}
