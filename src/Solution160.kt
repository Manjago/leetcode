fun main() {
    val a0 = ListNode(0)
    val a1 = ListNode(1)
    val a2 = ListNode(2)
    val a3 = ListNode(3)
    println(a0 + (a1 + (a2 + a3)))
    val test1 = ListNode(21) + a0
    val test2 = ListNode(23)  + (ListNode(22) + a0)
    println(test1)
    println(test2)
    val sol = Solution160()
    val result = sol.getIntersectionNode(test1, test2)
    println(result)
}

class Solution160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) {
            return null
        }

        if (headA === headB) {
            return headA
        }

        var pA = headA
        var pB = headB
        var paSecond = false
        var pbSecond = false
        var go = true
        while(go) {

            if (pA!!.next != null) {
                pA = pA!!.next
            } else {

                if (!paSecond) {
                    pA = headB
                    paSecond = true
                } else {
                   go = false
                }
            }

            if (pB!!.next != null) {
                pB = pB!!.next
            } else {

                if (!pbSecond) {
                    pB = headA
                    pbSecond = true
                } else {
                    go = false
                }
            }

            if (pA === pB) {
                return pA
            }
        }

        return null
    }

}