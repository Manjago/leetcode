/*
283. Move Zeroes https://leetcode.com/problems/move-zeroes/
Runtime: 2 ms, faster than 41.91% of Java online submissions for Move Zeroes.
Memory Usage: 40.4 MB, less than 53.26% of Java online submissions for Move Zeroes.
 */
public class Solution283_2 {
    public void moveZeroes(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return;
        }

        int futureIndex = -1;
        for (int i = 0; i < n; ++i) {


            if (nums[i] == 0) {
                if (futureIndex < 0) {
                    futureIndex = i;
                }

                while (((futureIndex + 1) < n) && nums[++futureIndex] == 0) {
                }


                if (nums[futureIndex] == 0) {
                    return;
                }

                nums[i] = nums[futureIndex];
                nums[futureIndex] = 0;
            }

        }
    }
}
