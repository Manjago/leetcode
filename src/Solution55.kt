// https://leetcode.com/problems/jump-game/
class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        var lastPos: Int = nums.lastIndex
        for (i in nums.lastIndex downTo 0) {
            if (i + nums[i] >= lastPos) {
                lastPos = i
            }
        }
        return lastPos == 0
    }
}