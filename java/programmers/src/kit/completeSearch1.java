package kit;

import java.util.*;

public class completeSearch1 {
    static HashSet<Integer> cache = new HashSet<>();
    static int res = 0, numbersLen = 0;
    static String[] numbers;
    static boolean[] visited;

    public int solution(String input) {
        numbers = input.split("");

        numbersLen = numbers.length;

        for(int i=1; i <= numbersLen; i++){
            visited = new boolean[numbersLen];
            permutation(0, new String[i]);
        }

        return res;
    }

    public static void permutation(int cnt, String[] selected) {
        if(cnt == selected.length) {
            String item = "";
            for(int i=0; i<selected.length; i++){
                item += selected[i];
            }

            int makeNum = stoi(item);

            if(cache.contains(makeNum) || makeNum == 0) return;

            if(checkPrimeNumber(makeNum)) {
                cache.add(makeNum);
                res += 1;
            }

            return;
        }

        for(int i = 0; i < numbersLen; i++){
            if(visited[i]) continue;

            visited[i] = true;
            selected[cnt] = numbers[i];
            permutation(cnt + 1, selected);
            visited[i] = false;
        }
    }

    public static boolean checkPrimeNumber(int value){
        if(value < 2) return false;

        for(int i=2; i * i <= value; i++){
            if(value % i == 0) return false;
        }

        return true;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        completeSearch1 sol = new completeSearch1();

        sol.solution("18");
    }
}
