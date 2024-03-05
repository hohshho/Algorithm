# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.leafList = []
        self.result = True
        self.checkIndex = 0

    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """

        self.dfs(root1, 1)
        self.dfs(root2, 2)

        print(self.leafList)

        return self.result if self.checkIndex == len(self.leafList) else False

    # mode = 1, make leaf list
    # mode = 2, check node using leaf list
    def dfs(self, node, mode):
        if(self.result == False): return

        if(node.left is not None):
            self.dfs(node.left, mode)
        if(node.right is not None):
            self.dfs(node.right, mode)
        
        if(node.left is not None or node.right is not None):
            return

        if(mode == 1):
            self.leafList.append(node.val)
        if(mode == 2):
            if(self.checkIndex == len(self.leafList)):
                self.result = False
                return

            if(self.leafList[self.checkIndex] != node.val):
                self.result = False
            self.checkIndex += 1

        
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.leafList = []
        self.result = True
        self.checkIndex = 0

    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """

        leaves1, leaves2 = [], []

        self.getLeaves(root1, leaves1)
        self.getLeaves(root2, leaves2)

        return leaves1 == leaves2

    def getLeaves(self, root, leaves):
        if root is None:
            return
        
        if root.left is None and root.right is None:
            leaves.append(root.val)

        self.getLeaves(root.left, leaves)
        self.getLeaves(root.right, leaves)


        