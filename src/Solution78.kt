import kotlin.math.pow

fun main() {
    val s = Solution78()
    println(s.subsets(intArrayOf(1,2,3)))
}

// https://leetcode.com/problems/subsets/
class Solution78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val output: MutableList<List<Int>> = mutableListOf()
        val n: Int = nums.size

        for (i in 2.0.pow(n.toDouble()).toInt() until 2.0.pow(n + 1.toDouble()).toInt()) {
            val bitmask = Integer.toBinaryString(i).substring(1)

            val curr: MutableList<Int> = mutableListOf()
            for (j in 0 until n) {
                if (bitmask[j] == '1') curr.add(nums[j])
            }
            output.add(curr)
        }
        return output
    }

}