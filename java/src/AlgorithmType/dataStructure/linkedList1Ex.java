package dataStructure;

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
 * 1. One Way Linked List - �迭���� �ٸ��� ���̰� ������ ���� �ʴ´�. - c�� �ٸ��� java�� �˾Ƽ� �����ʴ�
 * �޸𸮴� �����ش�. - c������ �ּҸ� �����ͷ� �־��µ�, �ڹٴ� ��� ��ü ��ü�� ���� �־��ָ� ������ �ȴ�. - ��øŬ������ ��带
 * �����ϴ� ��� �ִ� Ŭ���� ����.
 */