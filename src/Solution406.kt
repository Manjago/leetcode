import java.util.*

// https://leetcode.com/problems/queue-reconstruction-by-height/
class Solution406 {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {

        Arrays.sort(people) { a1, a2 ->
            if (a1[0] != a2[0]) {
                a2[0] - a1[0]
            } else {
                a1[1] - a2[1]
            }
        }

        val list = ArrayList<IntArray>()

        for (element in people) {
            val arr = element
            list.add(arr[1], arr)
        }

        return list.asSequence().toList().toTypedArray()
    }
}