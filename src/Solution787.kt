import java.util.*

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
class Solution787 {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val prices: MutableMap<Int, MutableMap<Int, Int>> = HashMap()
        for (f in flights) {
            if (!prices.containsKey(f[0])) prices[f[0]] = HashMap()
            prices[f[0]]!![f[1]] = f[2]
        }
        val pq: Queue<IntArray> = PriorityQueue(Comparator { a: IntArray, b: IntArray -> a[0].compareTo(b[0]) })
        pq.add(intArrayOf(0, src, K + 1))
        while (!pq.isEmpty()) {
            val top = pq.remove()
            val price = top[0]
            val city = top[1]
            val stops = top[2]
            if (city == dst) return price
            if (stops > 0) {
                val adj: Map<Int, Int> = prices.getOrDefault(city, HashMap())
                for (a in adj.keys) {
                    pq.add(intArrayOf(price + adj.getValue(a), a, stops - 1))
                }
            }
        }
        return -1
    }
}