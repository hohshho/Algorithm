import java.util.*;

public class num104 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            return getDepth(root);
        }

        public int getDepth(TreeNode root) {
            Queue<Node> q = new LinkedList<>();
            int maxDepth = 1;

            q.add(new Node(root, maxDepth));
            while (!q.isEmpty()) {
                Node cur = q.poll();
                int nextDepth = cur.depth + 1;

                if (cur.tree.left != null) {
                    q.add(new Node(cur.tree.left, nextDepth));
                    maxDepth = Math.max(maxDepth, nextDepth);
                }
                if (cur.tree.right != null) {
                    q.add(new Node(cur.tree.right, nextDepth));
                    maxDepth = Math.max(maxDepth, nextDepth);
                }
            }

            return maxDepth;
        }

        class Node {
            TreeNode tree;
            int depth;

            Node(TreeNode tree, int depth) {
                this.tree = tree;
                this.depth = depth;
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
}
