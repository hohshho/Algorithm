package kit;

import java.util.*;
class stack_주식가격 {
    public int[] solution(int[] prices) {
        Stack<Joo> stack = new Stack<>();
        int len = prices.length;
        int[] answer = new int[len];

        for(int i=0 ; i<len ; i++){
            while(!stack.isEmpty() && stack.peek().price>prices[i]){
                Joo j = stack.pop();
                answer[j.time] = i - j.time;
            }
            stack.push(new Joo(prices[i], i));
        }
        while(!stack.isEmpty()){
            Joo j = stack.pop();
            answer[j.time] = len - j.time-1;
        }
        return answer;
    }
}
class Joo{
    int time;
    int price;
    Joo(int price, int time){
        this.price = price;
        this.time = time;
    }
}