# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.maxDepth = -1
        self.rightSideMap = dict()

    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        answer = []

        if root != None:
            self.dfs(root, 0)

        for i in range(0, self.maxDepth + 1):
            answer.append(self.rightSideMap[i])
        return answer
    
    def dfs(self, root, curDepth):
        if root == None:
            return

        if(self.maxDepth < curDepth):
            self.maxDepth = curDepth
        
        if curDepth not in self.rightSideMap:
            self.rightSideMap[curDepth] = root.val
        
        self.dfs(root.right, curDepth + 1)
        self.dfs(root.left, curDepth + 1)