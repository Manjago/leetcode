import kotlin.test.assertEquals

fun main() {
    val solution = Solution3a()
    assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
    assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
    assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution3a {
    fun lengthOfLongestSubstring(s: String): Int {

        class Item(
            var freeze: Boolean,
            val entries: MutableSet<Char>
        )

        val data: MutableList<Item> = mutableListOf()
        var maxLen = 0
        s.asSequence().forEach { c ->

            data.asSequence().filter { !it.freeze }.forEach {
                val oldLen = it.entries.size
                it.entries.add(c)
                val newLen = it.entries.size
                if (newLen == oldLen) {
                    it.freeze = true
                } else {
                    if (maxLen < newLen) {
                        maxLen = newLen
                    }
                }
            }

            data.removeAll {
                it.freeze && it.entries.size < maxLen
            }

            data.add(Item(false, mutableSetOf(c)))
            if (maxLen < 1) {
                maxLen = 1
            }
        }

        return maxLen
    }


}