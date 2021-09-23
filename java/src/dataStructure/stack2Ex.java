package dataStructure;

import java.util.EmptyStackException;

class Stack2 {
	int data;
	int min;
	Stack2 next;
	Stack2() {
		
	}
	Stack2(int num) {
		this.data = num;
	}

	Stack2 top = null;

	void push(int num) {
		Stack2 newNode = new Stack2(num);
		if (top == null) {
			newNode.min = num;
			top = newNode;
		} else {
			if (top.min < newNode.data) {
				newNode.min = top.min;
			} else {
				newNode.min = newNode.data;
			}
			newNode.next = top;
			top = newNode;
		}
	}

	int pop() {
		if(top == null) throw new EmptyStackException();
		int item;
		item = top.data;
		top = top.next;
		return item;	
	}
}

public class stack2Ex {

	public static void main(String[] args) {
		Stack2 stack = new Stack2();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.top.data);
		System.out.println(stack.top.min);
		System.out.println(stack.pop());
		System.out.println(stack.top.data);
		System.out.println(stack.top.min);
		
	}

}
