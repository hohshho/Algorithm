import java.util.*;

public class num637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Node> nodes = new LinkedList<>();
        List<Double> result = new LinkedList<>();

        getResult(root, 1, nodes);

        for(Node cur : nodes){
            result.add((double) cur.sum / (double) cur.cnt);
        }

        return result;
    }

    public void getResult(TreeNode root, int depth, List<Node> nodes) {
        if(root == null) return;

        if(nodes.size() < depth) {
            nodes.add(new Node());
        }

        nodes.get(depth - 1).add(root.val);

        getResult(root.right, depth + 1, nodes);
        getResult(root.left, depth + 1, nodes);
    }

    class Node {
        double cnt;
        double sum;
        Node(){
            this.cnt = 0;
            this.sum = 0;
        }

        public void add(int val) {
            this.cnt += 1;
            this.sum += val;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
