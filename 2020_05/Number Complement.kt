import kotlin.math.pow

class Solution {
    fun findComplement(num: Int): Int {
        val digits = Integer.toBinaryString(num).length
        val square = 2.0.pow(digits).toInt()

        return if (square == Int.MAX_VALUE) {
            square - num
        } else {
            square - num - 1
        }
    }
}
