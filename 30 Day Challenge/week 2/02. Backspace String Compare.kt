class Solution {
    fun backspaceCompare(S: String, T: String): Boolean {
        var (S1, T1) = S to T
        while (S1.indexOf('#') != -1) {
            val sharpIndex = S1.indexOf('#')
            S1 = if (sharpIndex == 0) {
                S1.substring(sharpIndex + 1, S1.length)
            } else {
                S1.substring(0, sharpIndex - 1) + S1.substring(sharpIndex + 1, S1.length)
            }
        }
        while (T1.indexOf('#') != -1) {
            val sharpIndex = T1.indexOf('#')
            T1 = if (sharpIndex == 0) {
                T1.substring(sharpIndex + 1, T1.length)
            } else {
                T1.substring(0, sharpIndex - 1) + T1.substring(sharpIndex + 1, T1.length)
            }
        }

        return S1 == T1
    }
}
