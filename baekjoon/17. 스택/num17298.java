package package17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int resultIndex = N-1;
		int[] result = new int[N];
		int[] arr = new int[N];
		String[] arrData = br.readLine().split(" ");
		int value = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(arrData[i]);
		}
		
		for(int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
            	stack.pop();
            }
            if(stack.isEmpty()) {
                arr[i] = -1;
            } else {
                arr[i] = stack.peek();
            }
            stack.push(arr[i]);
			
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(result[i] + " ");
		}
	}
}
