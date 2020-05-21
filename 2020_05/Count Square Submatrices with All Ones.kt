class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val (row, col) = matrix.size to matrix[0].size

        var result = 0
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = matrix[i - 1][j - 1].coerceAtMost(matrix[i - 1][j].coerceAtMost(matrix[i][j - 1])) + 1
                }
                result += matrix[i][j]
            }
        }
        return result
    }
}
