/*
136. Single Number
https://leetcode.com/problems/single-number/
Runtime: 2 ms, faster than 56.43% of Java online submissions for Single Number.
Memory Usage: 39.2 MB, less than 72.38% of Java online submissions for Single Number.
 */
public class Solution136 {

    /*
    Constraints:
    1 <= nums.length <= 3 * 10^4
    -3 * 10^4 <= nums[i] <= 3 * 10^4
    */

    private static final int MIN = -30000;
    private static final int MAX = 30000;

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 2, 1}));
    }

    private static int singleNumber(int[] nums) {

        final int n = nums.length;
        if (n == 0) {
            return -1;
        }

        final int shift = -MIN;
        final boolean[] data = new boolean[MAX + shift];

        int minIndex = 3 * MAX;
        int maxIndex = -1;

        for (int i = 0; i < n; ++i) {
            final int index = nums[i] + shift;

            if (!data[index]) {
                data[index] = true;
            } else {
                data[index] = false;
            }

            if (index < minIndex) {
                minIndex = index;
            }
            if (index > maxIndex) {
                maxIndex = index;
            }
        }

        for (int index = minIndex; index <= maxIndex; ++index) {
            if (data[index]) {
                return index - shift;
            }
        }

        return -1;
    }
}
