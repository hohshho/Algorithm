
class Queue<T>{
	class Node<T>{
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
	}
	Node<T> head,tail;
	
	void add(T data){
		Node<T> newNode = new Node<T>(data);
		if(tail!= null) {
			tail.next = newNode;
		}
		tail = newNode;
		if(head == null)
			head = newNode;
	
	}
	
	T pop() {
		T item = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		return item;
	}
	
	T peek() {
		return head.data;
	}
	
	boolean isEmpty() {
		if(head == null)
			return false;
		return true;
	}
	
}

public class queueEx {
	
	public static void main(String[] args) {
		Queue<Integer> g = new Queue<Integer>();
		g.add(1);
		g.add(2);
		g.add(3);
		System.out.println(g.pop());
		System.out.println(g.pop());
		
		
	}

}
