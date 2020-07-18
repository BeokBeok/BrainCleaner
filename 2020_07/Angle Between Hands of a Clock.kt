class Solution {
    fun angleClock(hour: Int, minutes: Int): Double {
        val hourToMinute = hour * 5 + (5 * minutes / 60.0)

        val result = if (hourToMinute > minutes) {
            (hourToMinute - minutes) * 6
        } else {
            (minutes - hourToMinute) * 6
        }

        return (360 - result).coerceAtMost(result)
    }
}
