class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.ans = 0

    def averageOfSubtree(self, root: TreeNode) -> int:
        self.dfs(root)
        return self.ans

    def dfs(self, root: TreeNode) -> list[int]:
        if not root:
            return [0, 0]

        left = self.dfs(root.left)
        right = self.dfs(root.right)

        total_sum = left[0] + right[0] + root.val
        count = left[1] + right[1] + 1

        if root.val == total_sum // count:
            self.ans += 1

        return [total_sum, count]


# Creating the tree
root = TreeNode(4)
root.left = TreeNode(8)
root.right = TreeNode(5)

root.left.left = TreeNode(0)
root.left.right = TreeNode(1)

root.right.right = TreeNode(6)

sol = Solution()
print(sol.averageOfSubtree(root))