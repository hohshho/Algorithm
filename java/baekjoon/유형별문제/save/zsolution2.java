package save;

import java.util.*;

public class zsolution2 {
    static HashSet<String> answer = new HashSet<>();
    static ArrayList<String> student = new ArrayList<String>();
    static HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
    static int[] selectedUserIdx = new int[2];


    static class solution {
        public String[] solution(String[] logs) {

            for (String item : logs) {
                String[] itemArr = item.split(" ");

                String name = itemArr[0];
                int pNum = stoi(itemArr[1]);
                int score = stoi(itemArr[2]);

                if (!student.contains(name)) {
                    student.add(name);
                    map.put(name, new HashMap<Integer, Integer>());
                }

                HashMap pList = map.get(name);
                pList.put(pNum, score);
            }

            selectUser(0, 0);

            String[] result = answer.toArray(new String[0]);
            Arrays.sort(result);

            return answer.size() == 0 ? new String[] {"None"} : result;
        }

        public static void selectUser(int idx, int cnt) {
            if (cnt == 2) {
                checkUser();
                return;
            }

            for (int i = idx; i < student.size(); i++) {
                selectedUserIdx[cnt] = i;
                selectUser(idx + 1, cnt + 1);
            }
        }

        public static void checkUser() {
            String userName1 = student.get(selectedUserIdx[0]);
            String userName2 = student.get(selectedUserIdx[1]);

            HashMap<Integer, Integer> userProblemList1 = map.get(userName1);
            HashMap<Integer, Integer> userProblemList2 = map.get(userName2);

            // 1. 두 수험자 푼 문제수 검사
            if(userProblemList1.size() != userProblemList2.size() && userProblemList1.size() < 5) {
                return;
            }

            // 2. 번호, 점수 검사
            for(int pNum : userProblemList1.keySet()) {
                int score = userProblemList1.get(pNum);

                // 같이 푼 문제 있는지 검사
                if(!userProblemList1.containsKey(pNum)) {
                    return;
                }

                // 점수 검사
                if(userProblemList1.get(pNum) != userProblemList2.get(pNum)){
                    return;
                }
            }

            answer.add(userName1);
            answer.add(userName2);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        zsolution2.solution a = new zsolution2.solution();

        String[] data = new String[] {};

        System.out.println(a.solution(data));
    }
}
