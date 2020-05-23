import java.lang.IllegalArgumentException
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val s = Solution79()

    val board = arrayOf(charArrayOf('A','B','C','E'),
        charArrayOf('S','F','C','S'),
        charArrayOf('A','D','E','E')
    )
    assertTrue(s.exist(board, "ABCCED"))
    assertTrue(s.exist(board, "SEE"))
    assertFalse(s.exist(board, "ABCB"))
}

// https://leetcode.com/problems/word-search/
class Solution79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val toFind = word.toCharArray()
        if (toFind.isEmpty()) {
            throw IllegalArgumentException()
        }
        val firstChar = toFind[0]
        val exBoard = mutableMapOf<Cell, Char>()
        board.asSequence().forEachIndexed { index, chars ->
            val cells = chars.asSequence().mapIndexed { j, ch ->
                j to ch
            }.map {  Cell(index, it.first) to it.second}.toMap()
            exBoard.putAll(cells)
        }

        val pretenders = exBoard.entries.asSequence()
            .filter { it.value == firstChar }
            .map { it.key }
            .toSet()


        if (pretenders.isEmpty()) {
            return false
        }

        if (toFind.size < 2) {
            return true
        }

        pretenders.forEach {pretender ->
            val result = search(exBoard, setOf(pretender), toFind, 1, pretender)
            if (result) {
                return true
            }
        }

        return false
    }

    private data class Cell(val i: Int, val j: Int)

    private fun search(
        board: Map<Cell, Char>,
        exclusions: Set<Cell>,
        toFind: CharArray,
        searchPos: Int,
        start: Cell
    ): Boolean {

        if (searchPos > toFind.lastIndex) {
            return false
        }

        val char = toFind[searchPos]

        if (subSearch(start.i, start.j + 1, char, board, exclusions, toFind, searchPos)) {
            return true
        }
        if (subSearch(start.i + 1, start.j, char, board, exclusions, toFind, searchPos)) {
            return true
        }
        if (subSearch(start.i - 1, start.j, char, board, exclusions, toFind, searchPos)) {
            return true
        }
        if (subSearch(start.i, start.j - 1, char, board, exclusions, toFind, searchPos)) {
            return true
        }

        return false
    }

    private fun subSearch(i: Int, j: Int, char: Char, board: Map<Cell, Char>,
                          exclusions: Set<Cell>,
                          toFind: CharArray,
                          searchPos: Int): Boolean {
        val next = Cell(i, j)
        if (!exclusions.contains(next) && (char == board[next])) {
            if (searchPos == toFind.lastIndex) {
                return true
            }
            val nextStepResult = search(board, exclusions.plus(next), toFind, searchPos + 1, next)
            if (nextStepResult) {
                return true
            }
        }
        return false
    }
}