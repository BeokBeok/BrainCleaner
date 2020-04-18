class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        val (row, col) = grid.size to grid[0].size

        var result = 0
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == '1') {
                    makeDFS(grid, i, j)
                    result++
                }
            }
        }
        return result
    }
    
    private fun makeDFS(grid: Array<CharArray>, row: Int, col: Int) {
        if (row < 0 || col < 0) return
        if (row >= grid.size || col >= grid[0].size) return
        if (grid[row][col] == '0') return

        grid[row][col] = '0'
        makeDFS(grid, row, col - 1) // left
        makeDFS(grid, row - 1, col) // top
        makeDFS(grid, row, col + 1) // right
        makeDFS(grid, row + 1, col) // bot
    }
}
