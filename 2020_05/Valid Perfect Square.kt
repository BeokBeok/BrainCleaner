class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var (low, high) = 1 to num
        var mid: Long
        while (low <= high) {
            mid = (low + high).ushr(1).toLong()
            when {
                (mid * mid).toInt() == num -> return true
                mid * mid < num -> low = mid.toInt() + 1
                else -> high = mid.toInt() - 1
            }
        }
        return false
    }
}
