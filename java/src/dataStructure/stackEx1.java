package dataStructure;

import java.util.EmptyStackException;

class Stack<T>{
	class Node<T>{
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> top;
	
	T pop(){
		if(top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	void push(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = top;
		top = newNode;
	}
	
	T peek() {
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}

public class stackEx1 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(3);
		stack.push(5);
		stack.push(4);
		int a = stack.peek();
		System.out.println(a);
		stack.pop();
		int b = stack.peek();
		System.out.println(b);
	}
}
