package save;

import java.util.HashSet;
import java.util.Set;

public class kSolution1 {
    public String solution(String S, String C) {
        Set<String> set = new HashSet<>();

        String[] names = S.split(", ");

        String answer = "";

        for(int i=0; i < names.length; i++) {
            String[] partName = names[i].split(" ");
            int nameLen = partName.length;

            String First = partName[0].substring(0, 1).toLowerCase().trim();
            String Middle = "";
            String Last = partName[nameLen - 1].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
            if(Last.length() > 8) {
                Last = Last.substring(0, 8);
            }

            if(partName.length > 2) {
                Middle = partName[1].substring(0, 1).toLowerCase().trim();
            }
            String name = First + Middle + Last;

            if(set.contains(name)){
                int addIndex = 2;
                while(set.contains(name + Integer.toString(addIndex))) {
                    addIndex += 1;
                }

                name = name + Integer.toString(addIndex);
            }
            set.add(name);

            answer += names[i].trim() + " <" + name + "@" + C.toLowerCase() +".com>, ";
        }

        answer = answer.substring(0, answer.length() - 2);

        return answer;
    }

    public static void main(String[] args) {
        kSolution1 a = new kSolution1();
        System.out.println(a.solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker ", "Example"));
    }
}
