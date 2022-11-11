package level17_스택;

import java.util.*;

public class num10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<K; i++){
			int input = sc.nextInt();
			if(input==0) stack.pop();
			else stack.push(input);
		}
		sc.close();
		int sum = 0;
		for (Integer i : stack)
			sum+=i;
		System.out.print(sum);
	}
}
