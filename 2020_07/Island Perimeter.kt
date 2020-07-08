class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var (total, neighbours) = 0 to 0
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 1) {
                    total++

                    if (row < grid.size - 1 && grid[row + 1][col] == 1) neighbours++
                    if (col < grid[0].size - 1 && grid[row][col + 1] == 1) neighbours++
                }
            }
        }
        return total * 4 - neighbours * 2
    }
}
