import java.util.*
import kotlin.test.assertEquals

fun main() {

    val sol = Solution332()

    assertEquals("JFK, MUC, LHR, SFO, SJC", sol.findItinerary(listOf(
            listOf("MUC", "LHR"),
            listOf("JFK", "MUC"),
            listOf("SFO", "SJC"),
            listOf("LHR", "SFO")
    )).joinToString())

    assertEquals("JFK, ATL, JFK, SFO, ATL, SFO", sol.findItinerary(listOf(
            listOf("JFK", "SFO"),
            listOf("JFK", "ATL"),
            listOf("SFO", "ATL"),
            listOf("ATL", "JFK"),
            listOf("ATL", "SFO")
    )).joinToString())
}

// https://leetcode.com/problems/reconstruct-itinerary/
class Solution332 {

    fun findItinerary(tickets: List<List<String>>): List<String> {

        val map = HashMap<String, PriorityQueue<String>?>()
        val result = LinkedList<String>()

        fun dfs(s: String) {
            val q = map[s]
            while (q != null && !q.isEmpty()) {
                dfs(q.poll())
            }
            result.addFirst(s)
        }

        for (ticket in tickets) {
            if (!map.containsKey(ticket[0])) {
                val q = PriorityQueue<String>()
                map[ticket[0]] = q
            }
            map[ticket[0]]!!.offer(ticket[1])
        }
        dfs("JFK")
        return result

    }
}