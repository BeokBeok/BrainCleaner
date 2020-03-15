class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        if (n <= 0) return result

        if (n == 1) {
            result.add("()")
            return result
        }

        val toBeInsertedParenthesis = mutableSetOf<String>()
        generateParenthesis(n - 1).map { parenthesis ->
            for (i in parenthesis.indices) {
                val insertedParenthesis = StringBuilder(parenthesis).insert(i + 1, "()").toString()
                toBeInsertedParenthesis.add(insertedParenthesis)
            }
        }
        result.addAll(toBeInsertedParenthesis)
        return result
    }
}
