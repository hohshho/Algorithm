package package17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num10828 {

   public static void main(String[] args) throws IOException {
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Stack<Integer> stack = new Stack<Integer>();
	  
      int cnt = Integer.parseInt(br.readLine());
  
      for(int i=0; i<cnt; i++) {
    	  String[] data = br.readLine().split(" ");
    	  if(data[0].contains("push")) {
    		int input2 = Integer.parseInt(data[1]);
    		stack.push(input2);
    	  }else if(data[0].equals("pop")){
    		 System.out.println(stack.isEmpty()?-1:stack.pop());
    	  }else if(data[0].equals("size")) {
    		  System.out.println(stack.size());
    	  }else if(data[0].equals("empty")) {
    		 System.out.println(stack.isEmpty()?1:0);
    	  }else if(data[0].equals("top")) {
    		System.out.println(stack.isEmpty()?-1:stack.peek());
    	  }
      }
   }
}
