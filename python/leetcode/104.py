# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = 0

    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if(root is None):
            return self.result

        self.dfs(root, 1)

        return self.result
    
    def dfs(self, root, depth):
        self.result = depth if depth > self.result else self.result

        if(root.left is not None):
            self.dfs(root.left, depth + 1)
        if(root.right is not None):
            self.dfs(root.right, depth + 1)