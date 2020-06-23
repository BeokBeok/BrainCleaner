import kotlin.math.min

class Solution {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val (row, col) = dungeon.size to dungeon[0].size
        val hp = Array(row + 1) { IntArray(col + 1) { Int.MAX_VALUE } }
        hp[row - 1][col] = 1
        hp[row][col - 1] = 1

        for (i in row - 1 downTo 0) {
            for (j in col - 1 downTo 0) {
                val requireHp = min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j]
                hp[i][j] = if (requireHp <= 0) 1 else requireHp
            }
        }

        return hp[0][0]
    }
}
