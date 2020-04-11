class MinStack() {

    /** initialize your data structure here. */
    private val stack = Stack<Int>()
    private var min = Int.MAX_VALUE

    fun push(x: Int) {
        if (min >= x) {
            stack.push(min)
            min = x
        }
        stack.push(x)
    }

    fun pop() {
        if (min == stack.pop()) {
            min = stack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return min
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
