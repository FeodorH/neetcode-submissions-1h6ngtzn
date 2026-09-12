class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val queue = LinkedList<Pair<Int, Int>>()
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 0) {
                    queue.add(Pair(i, j))
                }
            }
        }
        while (!queue.isEmpty()) {
            val (x, y) = queue.poll()
            val nexts: Array<Pair<Int, Int>> = arrayOf(x - 1 to y, x + 1 to y, x to y - 1, x to y + 1)
            for ((x1, y1) in nexts){
                if ((x1 in 0 until grid.size)&&(y1 in 0 until grid[x1].size)) {
                    if (grid[x1][y1] != -1 && grid[x1][y1] > (grid[x][y] + 1)) {
                        grid[x1][y1] = grid[x][y] + 1
                        queue.add(Pair(x1, y1))
                    }
                }
            }
        }
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                print("${grid[i][j]} ")
            }
            println()
        }
    }
}
