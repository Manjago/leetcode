class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return toDebugString()
    }

    private fun toDebugString(maxCall: Int = 10): String {
        if (maxCall >= 0) {
            return "$`val`->" + (next?.toDebugString(maxCall - 1) ?: "NULL")
        } else {
            return "..."
        }
    }

    operator fun plus(b: ListNode?): ListNode {
        this.next = b
        return this
    }
}

fun IntArray?.toListNode(): ListNode? {
    if (this == null || this.isEmpty()) {
        return null
    }
    val top = ListNode(this[0])
    var current = top
    for (i in 1 until this.size) {
        current.next = ListNode(this[i])
        current = current.next!!
    }
    return top
}

