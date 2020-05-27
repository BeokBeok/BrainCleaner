class Solution {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val count = IntArray(N + 1)
        for (element in trust) {
            count[element[0]]--
            count[element[1]]++
        }
        for (i in 1..N) {
            if (count[i] == N - 1) return i
        }
        return -1
    }
}
