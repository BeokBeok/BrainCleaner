class Solution {
    fun countElements(arr: IntArray): Int {
        if (arr.size < 2) return 0
        val sortedArr = arr.sorted()

        var result = 0
        for (i in sortedArr.indices) {
            if (sortedArr.contains(sortedArr[i] + 1)) result++
        }
        return result
    }
}
