class FirstUnique(nums: IntArray) {

    private val unique = mutableSetOf<Int>()
    private val nonUnique = mutableSetOf<Int>()

    init {
        nums.forEach {
            add(it)
        }
    }

    fun showFirstUnique(): Int {
        if (unique.size == 0) return -1
        return unique.iterator().next()
    }

    fun add(value: Int) {
        if (nonUnique.contains(value)) return
        else if (unique.contains(value)) {
            nonUnique.add(value)
            unique.remove(value)
            return
        }
        unique.add(value)
    }

}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * var obj = FirstUnique(nums)
 * var param_1 = obj.showFirstUnique()
 * obj.add(value)
 */
