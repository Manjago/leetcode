// https://leetcode.com/problems/find-the-duplicate-number/
class Solution287 {
    fun findDuplicate(nums: IntArray): Int {

        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        var find = 0
        while (find != slow) {
            slow = nums[slow]
            find = nums[find]
        }
        return find
    }
}