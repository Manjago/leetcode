import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1002. Find Common Characters https://leetcode.com/problems/find-common-characters/
Runtime: 2 ms, faster than 98.48% of Java online submissions for Find Common Characters.
Memory Usage: 39.1 MB, less than 77.58% of Java online submissions for Find Common Characters.
 */
public class Solution1002 {
    private static final int MAX = 26;

    public List<String> commonChars(String[] words) {
        final int[] accum = new int[MAX];
        str2dict(words[0], accum);
        final int[] adder = new int[MAX];

        for(int i = 1; i < words.length; ++i)  {
            if (i != 1) {
                Arrays.fill(adder, 0);
            }
            str2dict(words[i], adder);
            intersect(accum, adder);
        }

        return dict2list(accum);
    }

    private List<String> dict2list(int[] dict) {
        final List<String> result = new ArrayList<>();

        for(int i = 0; i < MAX; ++i) {
            for(int j = 0; j < dict[i]; ++j) {
                result.add(String.valueOf(index2char(i)));
            }
        }

        return result;
    }

    private void intersect(int[] accum, int[] adder) {
        for(int i = 0; i < MAX; ++i) {
            accum[i] = min(accum[i], adder[i]);
        }
    }


    private int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    private void str2dict(String s, int[] dict) {
        for(int i = 0; i < s.length(); ++i) {
            ++dict[char2index(s.charAt(i))];
        }
    }

    private int char2index(char c) {
        return c - 'a';
    }

    private char index2char(int index) {
        return (char)(index + 'a');
    }
}
