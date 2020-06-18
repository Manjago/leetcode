// https://leetcode.com/problems/h-index-ii/
class Solution275 {
    fun hIndex(citations: IntArray): Int {
        val len = citations.size
        if (len == 0) {
            return 0
        }
        if (len == 1) {
            return if (citations[0] == 0) {
                0
            } else {
                1
            }
        }
        var i = 0
        var j = len - 1
        while (i < j) {
            val m = i + (j - i + 1) / 2
            if (citations[m] > len - m) {
                j = m - 1
            } else {
                i = m
            }
        }
        if (citations[j] > len - j) {
            return len
        }
        return if (citations[j] == len - j) {
            len - j
        } else {
            len - j - 1
        }
    }
}