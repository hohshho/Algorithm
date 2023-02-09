package KAKAO_BLIND_RECRUITMENT_2023;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class p1 {
    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
            ArrayList<Integer> answer = new ArrayList<Integer>();

            HashMap<String, Integer> roles = new HashMap<>();

            for(String item : terms) {
                String[] term = item.split(" ");
                roles.put(term[0], stoi(term[1]));
            }

            for(int i=0; i < privacies.length; i++){
                String[] privacy = privacies[i].split(" ");

                String role = privacy[1];
                String persnalItemDay = privacy[0];

                if(isPriodExpired(roles.get(role), persnalItemDay, today)) {
                    answer.add(i + 1);
                }
            }

            // ArrayList to array
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        boolean isPriodExpired(int period, String PersnalItemDay, String today) throws ParseException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Calendar cal = Calendar.getInstance();

            Date item = new Date();
            Date todayDate = new Date();

            item = format.parse(PersnalItemDay);
            todayDate = format.parse(today);

            cal.setTime(item);
            cal.add(Calendar.MONTH, period);

            return todayDate.compareTo(cal.getTime()) >= 0 ? true : false;
        }

        static int stoi(String s){
            return Integer.parseInt(s);
        }

    }

    public static void main(String[] args) throws ParseException {
        Solution sol = new Solution();
        int[] res = sol.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
}
