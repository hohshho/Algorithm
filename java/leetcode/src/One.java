public class One {

    Node top;
    int size;

    public One() {
        this.top = null;
        this.size = 0;
    }

    public void push(int value, String str) {
        Node newNode = new Node(value, str);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Node pop() {
        if (isEmpty()) {
            return null;
        }
        Node poppedNode = top;
        top = top.next;
        size--;
        return poppedNode;
    }

    public Node peek() {
        if (isEmpty()) {
            return null;
        }
        return top;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        One stack = new One();
        stack.push(1, "A");
        stack.push(2, "B");
        stack.push(3, "C");

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value + " " + node.str);
        }
    }

    class Node {
        int value;
        String str;
        Node next;

        public Node(int value, String str) {
            this.value = value;
            this.str = str;
            this.next = null;
        }
    }
}


