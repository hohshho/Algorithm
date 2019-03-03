package linkedList1;

class LinkedList {
	node head;

	LinkedList() {
		head = new node();
	}

	static class node {
		int data;
		node next = null;
	}

	void add(int a) {
		node end = new node();
		end.data = a;
		node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int a) {
		node n = head;
		while (n.next != null) {
			if (n.next.data == a) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	void show() {
		node n = head.next;
		while (n.next != null) {
			System.out.print(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

}

public class linkedList1Ex {
	public static void main(String args[]) {
		LinkedList list = new LinkedList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.show();
		list.delete(2);
	}
}

/*
 * 1. One Way Linked List - 배열과는 다르게 길이가 정해져 있지 않는다. - c와 다르게 java는 알아서 쓰지않는
 * 메모리는 버려준다. - c에서는 주소를 포인터로 넣었는데, 자바는 노드 객체 자체의 값을 넣어주면 구현이 된다. - 중첩클래스로 노드를
 * 포함하는 헤더 있는 클래스 만듬.
 */