import java.util.*;

public class num199 {
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
        int maxDepth = 0;

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<>();

            getResult(root, 1, result);

            return result;
        }

        public void getResult(TreeNode root, int depth, List<Integer> result) {
            if (root == null) return;

            if (maxDepth < depth) {
                result.add(root.val);
                maxDepth = depth;
            }

            getResult(root.right, depth + 1, result);
            getResult(root.left, depth + 1, result);
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
