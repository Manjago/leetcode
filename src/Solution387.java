/*
387. First Unique Character in a String https://leetcode.com/problems/first-unique-character-in-a-string/
Runtime: 7 ms, faster than 90.79% of Java online submissions for First Unique Character in a String.
Memory Usage: 39.5 MB, less than 74.20% of Java online submissions for First Unique Character in a String.
 */
public class Solution387 {
    // Note: You may assume the string contains only lowercase English letters.
    private static final int MAX_LEN = 26;

    public static int firstUniqChar(String s) {
        final int[] check = new int[MAX_LEN];
        final int n = s.length();

        for (int i = 0; i < n; ++i) {
            final char c = s.charAt(i);
            final int index = c - 'a';
            ++check[index];
        }

        for (int i = 0; i < n; ++i) {
            final char c = s.charAt(i);
            final int index = c - 'a';
            if (check[index] == 1) {
                return i;
            }
        }

        return -1;
    }

}
