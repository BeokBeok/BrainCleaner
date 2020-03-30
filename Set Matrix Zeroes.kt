class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val (row, col) = mutableSetOf<Int>() to mutableSetOf<Int>()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] != 0) continue
                row.add(i)
                col.add(j)
            }
        }

        if (row.isEmpty() && col.isEmpty()) return

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}
