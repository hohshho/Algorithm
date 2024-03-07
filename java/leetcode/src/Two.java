public class Two {
    One s1 = new One();
    One s2 = new One();

    public void enQueue(int value, String str) {
        s1.push(value, str);
    }

    public One.Node deQueue() {
        if (s1.top == null) {
            return null;
        }

        while(!s1.isEmpty()){
            One.Node node = s1.pop();
            s2.push(node.value, node.str);
        }

        One.Node dequeuedNode = s2.pop();

        while(!s2.isEmpty()) {
            One.Node node = s2.pop();
            s1.push(node.value, node.str);
        }

        return dequeuedNode;
    }

    public static void main(String[] args) {
        Two queue = new Two();
        queue.enQueue(1, "A");
        queue.enQueue(2, "B");
        queue.enQueue(3, "C");

        while (queue.s1.size != 0) {
            One.Node node = queue.deQueue();
            System.out.println(node.value + " " + node.str);
        }
    }
}