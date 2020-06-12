// https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {
    private val list: MutableList<Int> = mutableListOf()
    private val map: MutableMap<Int?, Int?> = mutableMapOf()

    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) return false
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`))
            return false
        val tmp = list[list.size - 1]
        val index = map[`val`]!!
        list[index] = tmp
        map[tmp] = index
        list.removeAt(list.size - 1)
        map.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return list[kotlin.random.Random.nextInt(list.size)]
    }

}