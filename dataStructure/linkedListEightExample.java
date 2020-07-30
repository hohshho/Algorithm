package linkedList2;

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
		tail.next = null; //마지막 값이 아닐 수 도 있어서

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
//1) 버퍼사용
//- Hashset 사용! (키 값을 가지고, 값을 찾는데 1밖에 안걸린다.)
//https://onsil-thegreenhouse.github.io/programming/java/2018/02/21/java_tutorial_1-23/
//지금 못 읽겠다 ㅠㅠㅠㅠ
//- space : O(n)
//- time : O(n)
//
//
//2) 버퍼 x 
//- 포인터 개념으로 맨앞의 값부터 끝까지 같은값이 있나 찾고, 있으면 삭제.
//- 마지막 코드를 삭제할 때 오류가 남.
//
//3. 뒤부터 세기
//- 1) k = 1, 전체노드 4일 경우. 전체노드세고 k를 뺀다. 그 후에 1을 더함.
//( 이 문제는 그렇게 쉽게 풀라고 만든 문제가 아니래 ㅋㅋㅋㅋㅋㅋㅋㅋ )
//- 2) 재귀호출
//(근데 나 왜 private 붙였는데 안되냐)
//  - 배열이나 객체는 스택에 포인터만 저장한다.
//  - 공간 : O(N) , 시간 : O(N)
//- 3) 포인터
//  - 예를 들어서 뒤에서 두번째 값을 찾고 싶을 때, 포인터를 하나 더 만들어서  
//     뒤로 2개 보내고 같이 이동 / 뒤에 포인터가 NULL을 만나면 앞의 포인터가
//     마지막에서 2번째 값이다. 
//  - 공간 : O(1) , 시간 : O(N)
//
//3. 문제! - 단방향 리스트에서 중간에 있는 노드를 삭제하시오. 
//   (첫번째 노드가 어딨는지 모르고, 오직 삭제 할 노드만 갖고있다.)
//
//4. linkedlist 값에 따라 나누기!
//문제 : 단방향 리스트에 있는 노드들을 x값을 기준으로 값이 작은 것들은 왼쪽, 
//           큰 것들은 오른쪽, 두 파트로 나누시오.
//(단, x는 오른쪽 파트 어디에 놔도 상관없다.)
//
//* 방법 1 : 두줄로 세우기
// - 줄마다 포인터 2개씩 선언해서, 먼저 
//
//* 방법 2 : 앞뒤로 붙이기
// - head와 tail 두개 포인터를 만든 후, 기준 값보다 작으면 head앞에 붙이고 기준값보다 크면 tail뒤에 붙인다. 그 후 두개 연결 
//tip!! - tail이 마지막 값이 아닐 수 도 있으니, 마지막 next는 null을 넣어줘야 한다.