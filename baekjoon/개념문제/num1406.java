package conceptProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();

		String[] stack1;
		String[] stack2;
	
		int stack1Size = 0;
		int stack2Size = 0;
		
		String data = br.readLine();
		
		stack1 = new String[600001];
		stack2 = new String[600001];
		
		for(int i=0;i<data.length();i++) {
			stack1[stack1Size] = Character.toString(data.charAt(i));
			stack1Size++;
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String[] line = br.readLine().split(" ");
			
			switch(line[0]) {
			case "P":
				stack1[stack1Size] = line[1];
				stack1Size += 1;
				break;
				
			case "L":
				if(stack1Size > 0) {
					stack2[stack2Size] = stack1[stack1Size-1];
					stack1[stack1Size-1] = null;
					stack2Size++;
					stack1Size--;
				}
				break;
			
			case "D":
				if(stack2Size>0) {
					stack1[stack1Size] = stack2[stack2Size-1];
					stack2[stack2Size-1] = null;
					stack1Size++;
					stack2Size--;
				}
				break;
				
			case"B":
				if(stack1Size>0) {
					stack1[stack1Size-1] = null;
					stack1Size-=1;
				}
				break;
				
				
			}
		}
		
		for(int i=0;i<stack1Size; i++) {
			str.append(stack1[i]);
		}
		
		for(int i=stack2Size; i>0;i--){
			str.append(stack2[i-1]);
		}
		System.out.println(str);
		
	}
}





//stack collection 프레임 워크 사용
//int n = Integer.parseInt(br.readLine());
//Stack lStack = new Stack<>();
//Stack rStack = new Stack<>();
//for(int i = 0; i < str.length(); i++)
//	lStack.add(str.charAt(i));
//
//while(n-- > 0) {
//	String cmd = br.readLine();
//
//	if(cmd.contains("P"))
//		lStack.add(cmd.charAt(2));
//	else {
//		switch(cmd) {
//		case "L": 
//			if(!lStack.isEmpty())
//				rStack.add(lStack.pop());
//			break;
//		case "D": 
//			if(!rStack.isEmpty())
//				lStack.add(rStack.pop());
//			break;
//		case "B": 
//			if(!lStack.isEmpty())
//				lStack.pop();
//			break;
//		}
//	}
//}
//while(!lStack.isEmpty()) rStack.add(lStack.pop());
//while(!rStack.isEmpty()) System.out.print(rStack.pop());