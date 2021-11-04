public class Solution283_1 {
    public void moveZeroes(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return;
        }

        int zeroesCount = 0;
        for(int i=0; i < n; ++i) {
            if (nums[i] == 0) {
                ++zeroesCount;
            }
        }

        if (zeroesCount == 0 || zeroesCount == n) {
            return;
        }

        int workIndex = 0;
        for(int i=0; i < n; ++i) {

            if (nums[i] != 0) {
                nums[workIndex++] = nums[i];
            }

            if (i >= (n - zeroesCount)) {
                nums[i] = 0;
            }
        }
    }
}
