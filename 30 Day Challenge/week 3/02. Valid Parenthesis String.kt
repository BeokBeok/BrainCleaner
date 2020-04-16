class Solution {
    fun checkValidString(s: String): Boolean {
        var (left, right) = 0 to 0
        for (i in s.toCharArray()) {
            when (i) {
                '(' -> {
                    left ++
                    right ++
                }
                ')' -> {
                    if (left > 0) left --
                    right --
                }
                else -> {
                    if (left > 0) left --
                    right ++
                }
            }
            if (right < 0) return false
        }

        return left == 0
    }
}
