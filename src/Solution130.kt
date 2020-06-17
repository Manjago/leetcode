import java.util.*

// https://leetcode.com/problems/surrounded-regions/
class Solution130 {

    fun solve(board: Array<CharArray>): Unit {

        fun bfs(o: Int, p: Int) {
            val m = board.size
            val n: Int = board[0].size
            val index = o * n + p
            val queue = LinkedList<Int>()
            queue.offer(index)
            board[o][p] = '1'
            while (!queue.isEmpty()) {
                val top = queue.poll()
                val i = top / n
                val j = top % n
                if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                    board[i - 1][j] = '1'
                    queue.offer((i - 1) * n + j)
                }
                if (i + 1 < m && board[i + 1][j] == 'O') {
                    board[i + 1][j] = '1'
                    queue.offer((i + 1) * n + j)
                }
                if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                    board[i][j - 1] = '1'
                    queue.offer(i * n + j - 1)
                }
                if (j + 1 < n && board[i][j + 1] == 'O') {
                    board[i][j + 1] = '1'
                    queue.offer(i * n + j + 1)
                }
            }
        }

        if (board.isEmpty() || board[0].isEmpty()) return
        val m = board.size
        val n: Int = board[0].size
        for (j in 0 until n) {
            if (board[0][j] == 'O') {
                bfs(0, j)
            }
        }
        for (j in 0 until n) {
            if (board[m - 1][j] == 'O') {
                bfs(m - 1, j)
            }
        }
        for (i in 0 until m) {
            if (board[i][0] == 'O') {
                bfs(i, 0)
            }
        }
        for (i in 0 until m) {
            if (board[i][n - 1] == 'O') {
                bfs(i, n - 1)
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O'
                }
            }
        }
    }
}