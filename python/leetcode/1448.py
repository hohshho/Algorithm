# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.result = 0

    def goodNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        nodes = []
        nodes.append([root.val, 0])

        self.dfs(root, nodes, 0)
        
        return self.result

    def dfs(self, root, nodes, depth):
        if(nodes[-1][0] <= root.val):
            self.result += 1
            nodes.append([root.val, depth])

        if(root.left is not None):
            self.dfs(root.left, nodes, depth + 1)
        if(root.right is not None):
            self.dfs(root.right, nodes, depth + 1)

        if(nodes[-1][1] == depth):
            nodes.pop()
