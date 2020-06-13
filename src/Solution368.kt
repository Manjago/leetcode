import java.util.*

// https://leetcode.com/problems/largest-divisible-subset/
class Solution368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val result: MutableList<Int> = ArrayList()
        if (nums.isEmpty()) return result
        Arrays.sort(nums)
        val t = IntArray(nums.size)
        val index = IntArray(nums.size)
        Arrays.fill(t, 1)
        Arrays.fill(index, -1)
        var max = 0
        var maxIndex = -1
        for (i in t.indices) {
            for (j in i - 1 downTo 0) {
                if (nums[i] % nums[j] == 0 && t[j] + 1 > t[i]) {
                    t[i] = t[j] + 1
                    index[i] = j
                }
            }
            if (max < t[i]) {
                max = t[i]
                maxIndex = i
            }
        }
        var i = maxIndex
        while (i >= 0) {
            result.add(nums[i])
            i = index[i]
        }
        return result
    }
}