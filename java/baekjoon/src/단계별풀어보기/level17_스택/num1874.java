package 단계별풀어보기.level17_스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class num1874 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> inputList = new ArrayList<Integer>();
		int i;
		
		// 1. 입력한 수를 List에 저장한다.
		for (i = 0; i < n; i++) {
			inputList.add(Integer.parseInt(br.readLine()));
		}

		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// 2. 1부터 n까지 순서대로 push 한다.
		for (i = 1; i <= n; i++) {
			stack.push(i);
			sb.append("+\n");
			// 3. 만약 stack 의 꼭대기 값과 저장한 list의 첫 번째 값과 같다면 pop 한다.
			while (!stack.isEmpty() && !inputList.isEmpty() && stack.peek().equals(inputList.get(0))) {
				stack.pop();
				inputList.remove(0);
				sb.append("-\n");
			}
		}
		
		// 4. 반복문을 모두 돌았지만 stack 이 비어 있지 않다면 스택 수열은 불가능한 경우이다.
		if(! stack.isEmpty()) {
			sb.setLength(0);
			sb.append("NO\n");
		}
		System.out.print(sb.toString());
	}
}