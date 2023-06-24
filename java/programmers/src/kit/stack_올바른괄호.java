package kit;

import java.util.*;

class stack_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();

        for(char item : s.toCharArray()){
            if(item == '(') {
                stack.push(item);
                continue;
            }

            if(stack.size() == 0) return false;

            stack.pop();
        }

        if(stack.size() != 0) return false;

        return true;
    }
}