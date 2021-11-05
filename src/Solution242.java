// https://leetcode.com/problems/valid-anagram/
// Runtime: 2 ms, faster than 95.87% of Java online submissions for Valid Anagram.
// Memory Usage: 39 MB, less than 87.87% of Java online submissions for Valid Anagram.
public class Solution242 {
    private static final int MAX_LEN = 26;

    public boolean isAnagram(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        if (sLen == 0) {
            return true;
        }

        final int[] dictS = new int[MAX_LEN];
        final int[] dictT = new int[MAX_LEN];
        str2dict(s, sLen, dictS);
        str2dict(t, tLen, dictT);
        for(int i=0; i<MAX_LEN; ++i) {
            if (dictS[i] != dictT[i]) {
                return false;
            }
        }
        return true;
    }

    private static void str2dict(String s, int len, int[] dict) {
        for(int i=0; i < len; ++i) {
            final char c = s.charAt(i);
            int index = c - 'a';
            ++dict[index];
        }
    }

}
