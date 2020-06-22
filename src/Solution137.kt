// https://leetcode.com/problems/single-number-ii/
class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        var threes: Int
        for (i in nums.indices) {
            twos = twos or (ones and nums[i])
            ones = ones xor nums[i]
            threes = ones and twos
            ones = ones and threes.inv()
            twos = twos and threes.inv()
        }
        return ones
    }
}