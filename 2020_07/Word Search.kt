class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        fun searchChaining(board: Array<CharArray>, word: String, index: Int, row: Int, col: Int): Boolean {
            if (index == word.length) return true
            if (row < 0 || col < 0 || row == board.size || col == board[0].size) return false
            if (board[row][col] != word[index]) return false
            board[row][col] = (board[row][col].toInt() xor 256).toChar()
            val result = searchChaining(board, word, index + 1, row, col - 1) ||
                    searchChaining(board, word, index + 1, row - 1, col) ||
                    searchChaining(board, word, index + 1, row, col + 1) ||
                    searchChaining(board, word, index + 1, row + 1, col)
            board[row][col] = (board[row][col].toInt() xor 256).toChar()
            return result
        }

        for (row in board.indices) {
            for (col in board[0].indices) {
                if (board[row][col] == word.toCharArray()[0]) {
                    if (searchChaining(board, word, 0, row, col)) return true
                }
            }
        }
        return false
    }
}
