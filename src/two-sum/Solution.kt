package `two-sum`

class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        for ((index, pretender) in nums.withIndex()) {
            val testValue = target - pretender

            val otherIndexHolder = nums.withIndex()
                .asSequence()
                .firstOrNull {
                    it.value == testValue && it.index != index
                }

            if (otherIndexHolder != null) {
                return intArrayOf(index, otherIndexHolder.index)
            }
        }

        throw IllegalArgumentException()

    }
}