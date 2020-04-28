class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0

        val (row, col) = matrix.size to matrix[0].size
        val dp = Array(row + 1) { IntArray(col + 1) }

        var max = 0
        for (i in 1..row) {
            for (j in 1..col) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = dp[i - 1][j - 1].coerceAtMost(dp[i][j - 1]).coerceAtMost(dp[i - 1][j]) + 1
                    max = dp[i][j].coerceAtLeast(max)
                }
            }
        }

        return max * max  
    }
}
