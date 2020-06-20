import java.util.*

// https://leetcode.com/problems/permutation-sequence/
class Solution60 {
    fun getPermutation(n: Int, k: Int): String {

        // initialize all numbers
        var ko = k
        val numberList = ArrayList<Int>()
        for (i in 1..n) {
            numberList.add(i)
        }

        // change k to be index
        ko--

        // set factorial of n
        var mod = 1
        for (i in 1..n) {
            mod *= i
        }
        var result = ""

        // find sequence
        for (i in 0 until n) {
            mod /= (n - i)
            // find the right number(curIndex) of
            val curIndex = ko / mod
            // update k
            ko %= mod

            // get number according to curIndex
            result += numberList[curIndex]
            // remove from list
            numberList.removeAt(curIndex)
        }
        return result
    }
}