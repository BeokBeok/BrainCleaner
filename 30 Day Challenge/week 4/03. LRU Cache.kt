class LRUCache(capacity: Int) {
    val lruList = mutableListOf<Map<Int, Int>>()
    val capacity = capacity

    fun get(key: Int): Int {
        for (element in lruList) {
            if (element.containsKey(key)) {
                put(key, element.getValue(key))
                return element.getValue(key)
            }
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        var containsKeyIndex = -1
        for (i in lruList.indices) {
            if (lruList[i].containsKey(key)) {
                containsKeyIndex = i
            }
        }
        if (containsKeyIndex > -1 ) {
            lruList.removeAt(containsKeyIndex)
        }
        lruList.add(0, mapOf(key to value))
        if (lruList.size > capacity) {
            lruList.removeAt(lruList.lastIndex)
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
