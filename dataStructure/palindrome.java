package linkedList4;

class node {
	int data;
	node next = null;

	node() {
	}

	node(int data) {
		this.data = data;
	}
}

class LinkedList4 {
	node head;

	LinkedList4() {
		head = new node();
	}

	node get(int a) {
		node n = head;
		for (int i = 0; i < a; i++) {
			n = n.next;
		}
		return n;
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

public class palindrome {
	private static boolean pail(node list) {
		node reverse = reverse(list);
		boolean a = isSame(list, reverse);
		while(list!=null) {
			System.out.print(list.data);
			list = list.next;	
		}
		
		while(reverse!=null) {
			System.out.print(reverse.data);
			reverse = reverse.next;	
		}
		
		return a;
	}

	private static boolean isSame(node list, node rever) {
		while (list != null && rever != null) {
			if (list.data != rever.data) {
				return false;
			}
			list = list.next;
			rever = rever.next;
		}
		
		return list == null && rever == null;
	}

	private static node reverse(node list) {
		node head = null;
		while (list != null) {
			node list2 = new node(list.data);
			list2.next = head;
			head = list2;
			list = list.next;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList4 list = new LinkedList4();

		list.add(4);
		list.add(2);
		list.add(2);
		list.add(4);
		list.add(0);
		list.show();

		boolean a = pail(list.head);
		if (a == true) {
			System.out.println("good");
		} else {
			System.out.println("sibal");
		}
	}
}
