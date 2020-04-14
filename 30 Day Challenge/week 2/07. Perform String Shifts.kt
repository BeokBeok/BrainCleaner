class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        if (s.length == 1) return s

        var shiftingStr = s
        for (element in shift) {
            val isLeft = when (element[0]) {
                0 -> true
                else -> false
            }
            if (isLeft) {
                shiftingStr += shiftingStr.substring(0, element[1])
                shiftingStr = shiftingStr.removeRange(0, element[1])
            } else {
                shiftingStr = shiftingStr.substring(shiftingStr.length - element[1], shiftingStr.length) + shiftingStr
                shiftingStr = shiftingStr.removeRange(shiftingStr.length - element[1], shiftingStr.length)
            }
        }
        return shiftingStr
    }
}
