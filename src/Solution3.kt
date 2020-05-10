import kotlin.test.assertEquals

fun main() {
    val s = Solution3()
    assertEquals(3, s.lengthOfLongestSubstring("abcabcbb")) //abc
    assertEquals(1, s.lengthOfLongestSubstring("bbbbb")) // b
    assertEquals(3, s.lengthOfLongestSubstring("pwwkew")) //wke
    assertEquals(0, s.lengthOfLongestSubstring("")) //

}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {

        var pretenderMax = 0
        val pretenders = mutableListOf<MutableList<Char>>()
        s.toCharArray().forEach { currentChar ->

            pretenders.removeAll { pretender ->
                pretender.contains(currentChar)
            }

            pretenders.forEach { it.add(currentChar) }
            pretenders.add(mutableListOf(currentChar))
            val localMax = pretenders.asSequence().map { it.size }.max()
            if (localMax != null && localMax > pretenderMax) {
                pretenderMax = localMax
            }
        }

        return pretenderMax
    }
}