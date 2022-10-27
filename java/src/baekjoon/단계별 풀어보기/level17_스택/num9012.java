package level17_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class num9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(testCase-- > 0) {
            Stack<Character> stack = new Stack<Character>();
            
            String str = br.readLine();
            boolean succ = true;
            for(int i=0; i < str.length(); i++) {
                char c = str.charAt(i);
                
                if(c == '(') {
                    stack.push(')');
                }else {
                    if(stack.isEmpty()) {
                        succ = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if(succ && stack.isEmpty()) {
                sb.append("YES \n");
            }else {
                sb.append("NO \n");
            }
        }
        System.out.println(sb.toString());
    }
}

