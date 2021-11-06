/*
350. Intersection of Two Arrays II https://leetcode.com/problems/intersection-of-two-arrays-ii/
Runtime: 1 ms, faster than 98.73% of Java online submissions for Intersection of Two Arrays II.
Memory Usage: 39.1 MB, less than 75.44% of Java online submissions for Intersection of Two Arrays II.
 */
public class Solution350_1 {
    private static final int MAX_LEN = 1001;

    public int[] intersect(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;

        final int[] counter1 = new int[MAX_LEN];
        final int[] counter2 = new int[MAX_LEN];

        count(nums1, n1, counter1);
        count(nums2, n2, counter2);

        // pass1 - find result length
        int lengthPretender = 0;
        int minIndex = MAX_LEN;
        int maxIndex = -1;
        for(int i = 0; i < MAX_LEN; ++i) {
            if (counter1[i] != 0 && counter2[i] != 0) {
                lengthPretender += min(counter1[i], counter2[i]);
                if (i < minIndex) {
                    minIndex = i;
                }
                if (i > maxIndex) {
                    maxIndex = i;
                }
            }
        }

        if (lengthPretender == 0) {
            return new int[0];
        }

        // pass 2 - fill result
        int index = 0;
        final int[] result = new int[lengthPretender];
        for (int i=minIndex; i <= maxIndex; ++i) {
            if (counter1[i] != 0 && counter2[i] != 0) {
                final int count = min(counter1[i], counter2[i]);
                for (int j = 0; j < count; ++j) {
                    result[index++] = i;
                }
            }
        }


        return result;
    }

    private static void count(int[] nums, int n, int[] counter) {
        for (int i = 0; i < n; ++i) {
            ++counter[nums[i]];
        }
    }

    private static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
