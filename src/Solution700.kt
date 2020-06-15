// https://leetcode.com/problems/search-in-a-binary-search-tree/
class Solution700 {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return when {
            root == null -> null
            `val` == root.`val` -> root
            `val` < root.`val` -> searchBST(root.left, `val`)
            else -> searchBST(root.right, `val`)
        }
    }
}