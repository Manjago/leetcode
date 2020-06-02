import kotlin.test.assertEquals

fun main() {
    val sol = Solution237()
    val origin = intArrayOf(4, 5, 1, 9).toListNode()
    sol.deleteNode(origin.findByVal(5))
    assertEquals("4->1->9->NULL", origin.toString())
}

// https://leetcode.com/problems/delete-node-in-a-linked-list/
class Solution237 {
    fun deleteNode(node: ListNode?) {
        node?.let {victim ->
            victim.next?.let {nextNode ->
                victim.`val` = nextNode.`val`
                victim.next = nextNode.next
            }
        }
    }
}