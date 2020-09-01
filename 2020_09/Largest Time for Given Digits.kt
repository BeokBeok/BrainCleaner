class Solution {
    fun largestTimeFromDigits(A: IntArray): String {
        var result = ""
        for (i in A.indices) {
            for (j in A.indices) {
                for (k in A.indices) {
                    if (i == j || j == k || k == i) continue
                    val h = "${A[i]}${A[j]}"
                    val m = "${A[k]}${A[6 - (i + j + k)]}"
                    val t = "$h:$m"
                    if (h < "24" && m < "60" && result < t) result = t
                }
            }
        }
        return result
    }
}
