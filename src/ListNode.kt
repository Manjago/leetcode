class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "$`val`->" + if (next != null) next.toString() else "NULL"
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