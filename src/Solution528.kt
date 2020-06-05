import java.util.*

// https://leetcode.com/problems/random-pick-with-weight/
class Solution528(w: IntArray) {

    private var max = 0
    private val arr: IntArray = IntArray(w.size)
    private val random = Random()

    init {
        arr[0] = w[0]
        max += w[0]
        for (i in 1 until w.size) {
            arr[i] = arr[i - 1] + w[i]
            max += w[i]
        }
    }

    fun pickIndex(): Int {
        val rnd = random.nextInt(max) + 1

        var ret = Arrays.binarySearch(arr, rnd)
        if (ret < 0) ret = -ret - 1
        return ret
    }
}