class Solution {
    fun numSquares(n: Int): Int {
        if (n < -1) return 0
        
        val list = mutableListOf<Int>().apply { add(0) }
        while (list.size <= n) {
            var (result, index) = Int.MAX_VALUE to 1
            while (index * index <= list.size) {
                result = result.coerceAtMost(list[list.size - (index * index)] + 1)
                index++
            }
            list.add(result)
        }
        return list[n]
    }
}
