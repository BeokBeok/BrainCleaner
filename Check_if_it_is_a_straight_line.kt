fun main() {
    val arrSuccess: Array<IntArray> = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(5, 6),
        intArrayOf(6, 7)
    )

    val arrFail: Array<IntArray> = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(2, 2),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(5, 6),
        intArrayOf(7, 7)
    )
    println(checkStraightLine(arrSuccess))
    println(checkStraightLine(arrFail))
}

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    val inclination = getInclination(coordinates[0], coordinates[1])

    var result = true
    for (i in 2 until coordinates.size) {
        if (inclination != getInclination(coordinates[0], coordinates[i])) {
            result = false
            break
        }
    }
    return result
}

fun getInclination(base: IntArray, target: IntArray) =
    (target[1] - base[1]).toFloat() / (target[0] - base[0]).toFloat()