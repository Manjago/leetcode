import kotlin.test.assertEquals

fun main() {
    val sol = Solution75()
    with(intArrayOf(2, 0, 2, 1, 1, 0)) {
        sol.sortColors(this)
        assertEquals("[0, 0, 1, 1, 2, 2]", this.contentToString())
    }
    with(intArrayOf(0, 2, 1, 0, 1, 2)) {
        sol.sortColors(this)
        assertEquals("[0, 0, 1, 1, 2, 2]", this.contentToString())
    }
}

// https://leetcode.com/problems/sort-colors/
class Solution75 {

    companion object {
        private const val RED = 0
        private const val BLUE = 2
    }

    fun sortColors(nums: IntArray): Unit {

        fun IntArray.swap(i: Int, j: Int) {
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }

        var redIndex = 0
        var blueIndex = nums.lastIndex
        var i = redIndex
        while (i <= blueIndex) {
            when (nums[i]) {
                RED -> nums.swap(i++, redIndex++)
                BLUE -> nums.swap(i, blueIndex--)
                else -> i++
            }
        }
    }

}