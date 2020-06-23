// https://leetcode.com/problems/count-complete-tree-nodes/
class Solution222 {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val left = getLeftHeight(root) + 1
        val right = getRightHeight(root) + 1
        return if (left == right) {
            (2 shl left - 1) - 1
        } else {
            countNodes(root.left) + countNodes(root.right) + 1
        }
    }

    private fun getLeftHeight(nparam: TreeNode?): Int {
        var n: TreeNode? = nparam ?: return 0
        var height = 0
        while (n!!.left != null) {
            height++
            n = n.left
        }
        return height
    }

    private fun getRightHeight(nparam: TreeNode?): Int {
        var n: TreeNode? = nparam ?: return 0
        var height = 0
        while (n!!.right != null) {
            height++
            n = n.right
        }
        return height
    }
}