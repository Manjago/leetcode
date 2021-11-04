public class Solution283 {
    public void moveZeroes(int[] nums) {
        final int n = nums.length;

        int writer = 0;
        while(writer < n) {

            while(nums[writer] != 0) {
                ++writer;
                if (writer == n) {
                    return;
                }
            }

            int reader = writer + 1;
            if (reader == n) {
                return;
            }

            while(nums[reader] == 0) {
                ++reader;
                if (reader == n) {
                    return;
                }
            }
            // writer = 0, reader != 0
            final int temp = nums[writer];
            nums[writer] = nums[reader];
            nums[reader] = temp;
            ++writer;
        }
    }
}
