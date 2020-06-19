import java.util.*
import kotlin.math.pow

// https://leetcode.com/problems/longest-duplicate-substring/
class Solution1044 {
    fun longestDupSubstring(S: String): String {
        val n = S.length
        val nums = IntArray(n)
        for (i in 0 until n) nums[i] = S[i].toInt() - 'a'.toInt()
        val a = 26
        val modulus = 2.0.pow(32.0).toLong()

        var left = 1
        var right = n
        var l: Int
        while (left != right) {
            l = left + (right - left) / 2
            if (search(l, a, modulus, n, nums) != -1) left = l + 1 else right = l
        }
        val start = search(left - 1, a, modulus, n, nums)
        return if (start != -1) S.substring(start, start + left - 1) else ""
    }

    private fun search(l: Int, a: Int, modulus: Long, n: Int, nums: IntArray): Int {
        var h: Long = 0
        for (i in 0 until l) h = (h * a + nums[i]) % modulus

        val seen: HashSet<Long?> = hashSetOf()
        seen.add(h)
        var aL: Long = 1
        for (i in 1..l) aL = aL * a % modulus
        for (start in 1 until n - l + 1) {
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus
            h = (h + nums[start + l - 1]) % modulus
            if (seen.contains(h)) return start
            seen.add(h)
        }
        return -1
    }
}