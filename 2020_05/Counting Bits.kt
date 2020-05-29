class Solution {
    fun countBits(num: Int): IntArray {
        var baseArr = intArrayOf(0,1,1,2)
        val length = Integer.toBinaryString(num).length
        return if (length < 3) {
            baseArr.take(num + 1).toIntArray()
        } else {
            for (i in 0..length - 3) {
                baseArr += baseArr.map { it + 1 }
            }
            baseArr.take(num + 1).toIntArray()
        }
    }
}
