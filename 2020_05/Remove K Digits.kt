class Solution {
    fun removeKdigits(num: String, k: Int): String {
        if (k == num.length) return "0"

        val stack = Stack<Char>()
        var kDigit = k
        for (i in num.indices) {
            // 스택에 있는 값 중에서 현재 값보다 큰 값은 전부 버림
            while (kDigit > 0 && stack.isNotEmpty() && stack.peek() > num[i]) {
                stack.pop()
                kDigit--
            }
            stack.push(num[i])
        }

        // 스택에 계속 추가만 된 경우, kDigit 이 0 이 될 때까지 스택 제거
        while (kDigit > 0) {
            stack.pop()
            kDigit--
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }
        sb.reverse()

        // 맨 앞에 있는 0 제거
        while (sb.length > 1 && sb[0] == '0') {
            sb.deleteCharAt(0)
        }
        return sb.toString()
    }
}
