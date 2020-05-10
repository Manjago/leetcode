import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val solution = Solution5()
    assertFalse(solution.isPalindrome("".toList()))
    assertTrue(solution.isPalindrome("a".toList()))
    assertTrue(solution.isPalindrome("aba".toList()))
    assertTrue(solution.isPalindrome("abba".toList()))
    assertFalse(solution.isPalindrome("abbab".toList()))
    assertEquals("abba", solution.longestPalindrome("abbab"))
    assertEquals("bab", solution.longestPalindrome("babad"))
    assertEquals("bb", solution.longestPalindrome("cbbd"))
    assertEquals("21312", solution.longestPalindrome("21312234dfhkjdsfhkj1231298390dfhsfkjhsdjfghg213213921sgfjhgsdfabba"))
    assertEquals("abbbbba", solution.longestPalindrome("21312234dfhkjdsfhkj1231298390dfhsfkjhsdjfghg213213921sgfjhgsdfabbbbba"))
}

// https://leetcode.com/problems/longest-palindromic-substring/
class Solution5 {
    fun longestPalindrome(s: String): String {

        class Item(
            val content: MutableList<Char>
        )

        val data: MutableList<Item> = mutableListOf()
        var maxPalindrome = ""
        s.asSequence().forEachIndexed() { index, c ->

            data.asSequence().forEach {
                it.content.add(c)
                if (isPalindrome(it.content) && maxPalindrome.length < it.content.size) {
                    maxPalindrome = it.content.joinToString("")
                }
            }

            data.add(Item(mutableListOf(c)))
            if (maxPalindrome == "") {
                maxPalindrome = c.toString()
            }
        }

        return maxPalindrome
    }

    fun isPalindrome(list: List<Char>) : Boolean {
        if (list.isEmpty()) {
            return false
        }
        if (list.size == 1) {
            return true
        }
        var first = 0
        var last = list.size - 1
        while(first < last) {
            if (list[first++] != list[last--]) {
                return false
            }
        }
        return true
    }
}