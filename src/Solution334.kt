import kotlin.test.assertTrue

fun main() {
    val s = Solution334()
    assertTrue(s.increasingTriplet(intArrayOf(50, 60, 20, 10, 30, 40, 70)))
}

// https://leetcode.com/problems/increasing-triplet-subsequence/
class Solution334 {
    fun increasingTriplet(nums: IntArray): Boolean {

        if (nums.size < 3) {
            return false
        }

        var a: Int = Integer.MAX_VALUE
        var b: Int = Integer.MAX_VALUE

        nums.forEach { c ->

            when {
                b < c -> return true
                c < a -> a = c
                c in (a + 1) until b -> b = c
            }

        }

        return false
    }
}