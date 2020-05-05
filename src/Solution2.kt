import java.math.BigInteger

// https://leetcode.com/problems/add-two-numbers/
class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null || l2 == null) {
            throw IllegalArgumentException()
        }

        return toListNode(toBigInteger(l1) + toBigInteger(l2))

    }

    fun toListNode(bigInteger: BigInteger): ListNode? {

        var current: ListNode? = null
        bigInteger.toString().toCharArray().forEach {
            if (current == null) {
                current = ListNode(it.toString().toInt())
            } else {
                val newitem = ListNode(it.toString().toInt())
                newitem.next = current
                current = newitem
            }
        }
        return current
    }

    fun toBigInteger(listNode: ListNode): BigInteger {
        val sb = StringBuilder()

        var current: ListNode? = listNode
        while (current != null) {
            sb.insert(0, current.`val`)
            current = current.next
        }

        return BigInteger(sb.toString())
    }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}