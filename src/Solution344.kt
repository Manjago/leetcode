import kotlin.test.assertEquals

fun main() {
    val sol = Solution344()
    val s = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    sol.reverseString(s)
    assertEquals("[h, a, n, n, a, H]", s.contentToString())
    val s2 = charArrayOf('1', '2', '3')
    sol.reverseString(s2)
    assertEquals("[3, 2, 1]", s2.contentToString())
    val s3 = charArrayOf('1', '2', '3', '4')
    sol.reverseString(s3)
    assertEquals("[4, 3, 2, 1]", s3.contentToString())
    val s4 = charArrayOf('1')
    sol.reverseString(s4)
    assertEquals("[1]", s4.contentToString())
    val s5 = charArrayOf()
    sol.reverseString(s5)
    assertEquals("[]", s5.contentToString())

}

// https://leetcode.com/problems/reverse-string/
class Solution344 {

    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            val temp = s[i]
            s[i++] = s[j]
            s[j--] = temp
        }
    }
}