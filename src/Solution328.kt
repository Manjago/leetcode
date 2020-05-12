import kotlin.test.assertEquals

fun main() {
    val s = Solution328()
    assertEquals(
        intArrayOf(1, 3, 5, 2, 4)
            .toListNode().toString(), s.oddEvenList(
            intArrayOf(1, 2, 3, 4, 5)
                .toListNode()
        ).toString()
    )

    assertEquals(
        intArrayOf(2, 3, 6, 7, 1, 5, 4)
            .toListNode().toString(), s.oddEvenList(
            intArrayOf(2, 1, 3, 5, 6, 4, 7)
                .toListNode()
        ).toString()
    )

    assertEquals(
        intArrayOf(2)
            .toListNode().toString(), s.oddEvenList(
            intArrayOf(2)
                .toListNode()
        ).toString()
    )

    assertEquals(
        intArrayOf(1, 2)
            .toListNode().toString(), s.oddEvenList(
            intArrayOf(1, 2)
                .toListNode()
        ).toString()
    )

    assertEquals(
        intArrayOf(1, 2, 3)
            .toListNode().toString(), s.oddEvenList(
            intArrayOf(1, 3, 2)
                .toListNode()
        ).toString()
    )
}

// https://leetcode.com/problems/odd-even-linked-list/
class Solution328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        var current = head
        var isOdd = true

        var oddHead: ListNode? = null
        var oddCurrent: ListNode? = null
        var evenHead: ListNode? = null
        var evenCurrent: ListNode? = null

        while (current != null) {

            if (isOdd) {

                if (oddHead == null) {
                    oddHead = current
                    oddCurrent = current
                } else {
                    oddCurrent!!.next = current
                    oddCurrent = oddCurrent.next
                }

            } else {
                if (evenHead == null) {
                    evenHead = current
                    evenCurrent = current
                } else {
                    evenCurrent!!.next = current
                    evenCurrent = evenCurrent.next
                }
            }

            current = current.next
            isOdd = !isOdd
        }

        if (oddHead == null) {
            return null
        }

        if (evenHead == null) {
            return head
        }

        evenCurrent!!.next = null
        oddCurrent!!.next = evenHead
        return oddHead
    }

}