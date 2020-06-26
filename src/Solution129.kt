// https://leetcode.com/problems/sum-root-to-leaf-numbers/
class Solution129 {
    fun sumNumbers(root: TreeNode?): Int {
        return if (root == null) 0 else dfs(root, 0, 0)
    }

    fun dfs(node: TreeNode?, paramNum: Int, paramSum: Int): Int {
        var num = paramNum
        var sum = paramSum
        if (node == null) return sum
        num = num * 10 + node.`val`

        if (node.left == null && node.right == null) {
            sum += num
            return sum
        }

        sum = dfs(node.left, num, sum) + dfs(node.right, num, sum)
        return sum
    }
}