package linkedList3;

import java.awt.List;

class node {
	int data;
	node next = null;
	node (){
	}
	node(int data){
		this.data = data;
	}
}

class Reference {
	public int count = 0;
}

class LinkedList3 {
	node head;

	LinkedList3() {
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

	void removeDu() {
		node n = head;

		while (n != null && n.next != null) {
			node pointer = n;
			while (pointer.next != null) {
				if (n.data == pointer.next.data) {
					pointer.next = pointer.next.next;
				} else {
					pointer = pointer.next;
				}
			}
			n = n.next;
		}
	}

	void nLast(int k) {
		node first = head;
		int count = 1;
		int num = 1;
		while (first.next != null) {
			count++;
			first = first.next;
		}
		node n = head;
		for (int i = 1; i < num - k + 1; i++) {
			n = n.next;
		}
		System.out.println();
	}

	node nLast2(node n, int k, Reference r) {
		if (n == null) {
			return null;
		}

		node found = nLast2(n.next, k, r);
		r.count++;
		if (r.count == k) {
			return n;
		}
		return found;
	}

	node nLast3(node n, int k) {
		node a = head;
		node b = head;
		for (int i = 0; i < k; i++) {
			if (b == null)
				return null;
			b = b.next;
		}

		while (b != null) {
			a = a.next;
			b = b.next;
		}
		return a;
	}
}

class cr{
	node result = null;
	int carry = 0;
}

public class linkedListRecursiveFunction {
	private static int getListLeng(node rel) {
		int leng=0;
		while(rel != null) {
			rel = rel.next;
			leng++;
		}
		return leng;
	}
	
	private static node insertBefore(node node, int data) {
		node before = new node(data);
		if(node != null) {
			before.next = node;
		}
		return before;
	}
	
	private static node paddingList(node list, int length) {
		node head = list;
		for(int i=0;i<length;i++) {
			head = insertBefore(head,0);
		}
		return head;
	}
	
	private static node sumList(node l1,node l2) {
		int len1 = getListLeng(l1);
		int len2 = getListLeng(l2);
		if(len1 > len2) {
			l1 = paddingList(l1,len2-len1);
		}else {
			l2 = paddingList(l2,len1-len2);
		}
		
		cr storage = addList(l1,l2);
		if(storage.carry!=0) {
			storage.result = insertBefore(storage.result,1);
		}
		return storage.result;
	}
	
	private static cr addList(node l1, node l2) {
		if(l1 == null && l2 == null) {
			cr storage = new cr();
			return storage;
		}
		cr storage = addList(l1.next,l2.next);
		int value = storage.carry + l1.data + l2.data ;
		int data = value % 10;
		storage.result = insertBefore(storage.result,data);
		storage.carry = value/10;
		return storage;
		
	}
	

//	private static node sumList(node l1, node l2, int c) {
//		if (l1 == null && l2 == null && c == 0) {
//			return null;
//		}
//		node result = new node();
//		int value = c;
//		if (l1 != null) {
//			value += l1.data;
//		}
//		if (l2 != null) {
//			value += l2.data;
//		}
//
//		result.data = value % 10;
//
//		if (l1 != null || l2 != null) {
//			node next = sumList(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
//			result.next = next;
//		}
//		return result;
//	}



	public static void main(String args[]) {
		LinkedList3 list1 = new LinkedList3();
		list1.add(9);
		list1.add(1);
		list1.add(4);
		list1.show();

		LinkedList3 list2 = new LinkedList3();
		list2.add(6);
		list2.add(4);
		list2.add(8);

		list2.show();

		node n = sumList(list1.get(1), list2.get(1));
		while (n.next != null) {
			System.out.print(n.data);
			n = n.next;
		}
		System.out.println(n.data);

	}
}
