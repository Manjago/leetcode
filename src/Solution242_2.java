// https://leetcode.com/problems/valid-anagram/
// Runtime: 3 ms, faster than 82.44% of Java online submissions for Valid Anagram.
// Memory Usage: 39.3 MB, less than 67.34% of Java online submissions for Valid Anagram.
public class Solution242_2 {
    private static final int MAX_LEN = 26;
    private static final char MIN_CHAR = 'a';

    private static boolean isAnagram(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }

        final int[] dict = new int[MAX_LEN];
        for(int i=0; i < tLen; ++i) {
            final char charS = s.charAt(i);
            final char charT = t.charAt(i);
            final int indexS = charS - MIN_CHAR;
            final int indexT = charT - MIN_CHAR;
            ++dict[indexS];
            --dict[indexT];
        }


        for(int i=0; i<MAX_LEN; ++i) {
            if (dict[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
