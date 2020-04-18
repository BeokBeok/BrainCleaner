class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        val (row, col) = grid.size to grid[0].size
        val minArr = IntArray(col)
        minArr[0] = grid[0][0]
        for (i in 1 until col) {
            minArr[i] = minArr[i - 1] + grid[0][i]
        }

        for (i in 1 until row) {
            minArr[0] += grid[i][0]
            for (j in 1 until col) {
                minArr[j] = minArr[j].coerceAtMost(minArr[j - 1]) + grid[i][j]
            }
        }
        return minArr[col - 1]
    }
}
