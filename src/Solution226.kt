// https://leetcode.com/problems/invert-binary-tree/
class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {

         return root?.let {
             invertTree(it.left)
             invertTree(it.right)

             val temp = it.left
             it.left = it.right
             it.right = temp
             it
         }

    }
}

