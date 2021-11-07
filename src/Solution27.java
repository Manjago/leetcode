/*
27. Remove Element https://leetcode.com/problems/remove-element/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
Memory Usage: 37.6 MB, less than 63.73% of Java online submissions for Remove Element.
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        //first pass - val count
        int valCount = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                ++valCount;
            }
        }

        //second pass - replace
        int readerIndex = n - valCount;
        for (int i = 0; i < n - valCount; ++i) {
            if (nums[i] == val) {

                while (nums[readerIndex] == val) {
                    ++readerIndex;
                }

                nums[i] = nums[readerIndex++];
            }
        }

        return n - valCount;
    }
}
