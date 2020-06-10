import kotlin.test.assertEquals

fun main() {
    val sol = Solution35()
    assertEquals(2, sol.searchInsert(intArrayOf(1,3,5,6), 5))
    assertEquals(1, sol.searchInsert(intArrayOf(1,3,5,6), 2))
    assertEquals(4, sol.searchInsert(intArrayOf(1,3,5,6), 7))
    assertEquals(0, sol.searchInsert(intArrayOf(1,3,5,6), 0))
}

// https://leetcode.com/problems/search-insert-position/
class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var i = 0
        var j = nums.size - 1
        while (i <= j) {
            val mid = (i + j) / 2
            when {
                target > nums[mid] -> {
                    i = mid + 1
                }
                target < nums[mid] -> {
                    j = mid - 1
                }
                else -> {
                    return mid
                }
            }
        }
        return i
    }
}