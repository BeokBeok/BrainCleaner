import kotlin.math.abs

class Solution {
    fun mirrorReflection(p: Int, q: Int): Int {
        val corners = arrayOf(
            listOf(p, 0),
            listOf(p, p),
            listOf(0, p)
        )
        val target = mutableListOf(p, q)

        // 기저 case
        if (corners.indexOf(target) != -1) return corners.indexOf(target)

        var isDesc = false
        while (corners.indexOf(target) == -1) {
            val x = target[0]
            var y = target[1]
            if (target[1] > p) {
                isDesc = true
                y = p * 2 - y
            }
            if (target[1] < 0) {
                isDesc = false
                y = abs(target[1])
            }

            target.clear()
            target.add(if (x == p) 0 else p)
            target.add(if (isDesc) y - q else y + q)
        }
        return corners.indexOf(target)
    }
}
