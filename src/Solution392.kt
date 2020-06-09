import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val sol = Solution392()
    assertFalse(sol.isSubsequence("b", "c"))
    assertFalse(sol.isSubsequence("ab", "ac"))
    assertFalse(sol.isSubsequence("ab", "a"))
    assertTrue(sol.isSubsequence("abc", "ahbgdc"))
    assertFalse(sol.isSubsequence("axc", "ahbgdc"))
    assertTrue(sol.isSubsequence("abc", "asdffdsbdfsdfsdfcfsdfsdfsdfdsf"))
    assertFalse(sol.isSubsequence("axc", "asdffdsbdfsdfsdfcfsdfsdfsdfdsf"))
    assertTrue(sol.isSubsequence("abc", "kasdffdsbdfsdfsdfcfsdfsdfsdfdsf"))
    assertFalse(sol.isSubsequence("axc", "kasdffdsbdfsdfsdfcfsdfsdfsdfdsf"))
}

// https://leetcode.com/problems/is-subsequence/
class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {

        if (s.isEmpty()) {
            return true
        }

        if (t.isEmpty()) {
            return false
        }

        var tindex = 0
        var bad = false
        var catched = 0
        for (index in 0..s.lastIndex) {
            val pretender = s[index]

            if (tindex > t.lastIndex) {
                bad = true
                break
            }

            do {

                val tmold = t[tindex]
                if (pretender == tmold) {
                    ++catched
                    ++tindex
                    break
                }

            } while (++tindex <= t.lastIndex)
        }

        if (bad) {
            return false
        }

        return catched == s.length
    }
}