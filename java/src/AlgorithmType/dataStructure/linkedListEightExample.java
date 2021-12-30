package dataStructure;

class node {
	int data;
	node next = null;
}

class LinkedList2 {
	node head;

	LinkedList2() {
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

class Reference {
	public int count = 0;
}

public class eightExample {
	private static boolean deleteNode(node n) {
		if (n == null || n.next == null) {
			return false;
		}
		node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	private static node Partition(node n, int x) {
		node s1 = null;
		node e1 = null;
		node s2 = null;
		node e2 = null;

		while (n != null) {
			node nextNode = n.next;
			n.next = null;
			if (n.data < x) {
				if (s1 == null) {
					s1 = n;
					e1 = s1;
				} else {
					e1.next = n;
					e1 = n;
				}
			} else {
				if (s2 == null) {
					s2 = n;
					e2 = s2;
				} else {
					e2.next = n;
					e2 = n;
				}
			}
			n = nextNode;
		}
		if (s1 == null) {
			return s2;
		}
		e1.next = s2;
		return s1;
	}
	
	private static node Partition2(node n,int x) {
		node head = n;
		node tail = n;
		while(n!=null) {
			node next = n.next;
			if(n.data<x) {
				n.next = head;
				head = n;
			}else {
				tail.next = n;
				tail=n;
			}
			n=next;
		}
		tail.next = null; //������ ���� �ƴ� �� �� �־

		return head;
	}

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.show();
		list.removeDu();
		list.add(3);
		list.removeDu();
		list.show();
		list.show();
		list.nLast(2);
		Reference r = new Reference();
		node found = list.nLast2(list.head, 1, r);
		System.out.println(found.data);
		node found2 = list.nLast3(list.head, 2);
		System.out.println(found2.data);
		list.show();
		list.add(2);
		list.add(3);
		list.add(4);
		deleteNode(list.get(3));
		list.show();
		node nn = Partition2(list.get(1), 2);
		while (nn.next != null) {
			System.out.print(nn.data + " ->");
			nn = nn.next;
		}
		System.out.println(nn.data);
	}

}
//2. One Way Linked List1 / remove duplication value
//1) ���ۻ��
//- Hashset ���! (Ű ���� ������, ���� ã�µ� 1�ۿ� �Ȱɸ���.)
//https://onsil-thegreenhouse.github.io/programming/java/2018/02/21/java_tutorial_1-23/
//���� �� �аڴ� �ФФФ�
//- space : O(n)
//- time : O(n)
//
//
//2) ���� x 
//- ������ �������� �Ǿ��� ������ ������ �������� �ֳ� ã��, ������ ����.
//- ������ �ڵ带 ������ �� ������ ��.
//
//3. �ں��� ����
//- 1) k = 1, ��ü��� 4�� ���. ��ü��弼�� k�� ����. �� �Ŀ� 1�� ����.
//( �� ������ �׷��� ���� Ǯ��� ���� ������ �ƴϷ� ���������������� )
//- 2) ���ȣ��
//(�ٵ� �� �� private �ٿ��µ� �ȵǳ�)
//  - �迭�̳� ��ü�� ���ÿ� �����͸� �����Ѵ�.
//  - ���� : O(N) , �ð� : O(N)
//- 3) ������
//  - ���� �� �ڿ��� �ι�° ���� ã�� ���� ��, �����͸� �ϳ� �� ����  
//     �ڷ� 2�� ������ ���� �̵� / �ڿ� �����Ͱ� NULL�� ������ ���� �����Ͱ�
//     ���������� 2��° ���̴�. 
//  - ���� : O(1) , �ð� : O(N)
//
//3. ����! - �ܹ��� ����Ʈ���� �߰��� �ִ� ��带 �����Ͻÿ�. 
//   (ù��° ��尡 ������� �𸣰�, ���� ���� �� ��常 �����ִ�.)
//
//4. linkedlist ���� ���� ������!
//���� : �ܹ��� ����Ʈ�� �ִ� ������ x���� �������� ���� ���� �͵��� ����, 
//           ū �͵��� ������, �� ��Ʈ�� �����ÿ�.
//(��, x�� ������ ��Ʈ ��� ���� �������.)
//
//* ��� 1 : ���ٷ� �����
// - �ٸ��� ������ 2���� �����ؼ�, ���� 
//
//* ��� 2 : �յڷ� ���̱�
// - head�� tail �ΰ� �����͸� ���� ��, ���� ������ ������ head�տ� ���̰� ���ذ����� ũ�� tail�ڿ� ���δ�. �� �� �ΰ� ���� 
//tip!! - tail�� ������ ���� �ƴ� �� �� ������, ������ next�� null�� �־���� �Ѵ�.