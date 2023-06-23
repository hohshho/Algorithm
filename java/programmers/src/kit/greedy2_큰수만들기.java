package kit;

import java.util.*;

class greedy2_큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";

        String[] list = number.split("");

        Stack<Integer> st = new Stack<Integer>();

        int cnt = 0;
        for(String item : list){
            int cur = stoi(item);

            while(!st.empty() && st.peek() < cur && cnt < k) {
                st.pop();
                cnt += 1;
            }

            st.push(cur);
        }

        cnt = 0;
        for(int item : st) {
            if(cnt == list.length - k) break;

            answer = answer + item;
            cnt += 1;
        }
        return answer;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}