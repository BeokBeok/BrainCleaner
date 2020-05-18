class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        val jArr = J.toCharArray()
        var result = 0
        for (element in jArr) {
            result += S.filter {
                it == element
            }.count()
        }
        return result
    }
}
