class Solution {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        if (N == 1 && trust.isEmpty()) return 1
        
        val map = HashMap<Int, MutableList<Int>>()
        for (element in trust) {
            map.computeIfAbsent(element[1]) { mutableListOf() }
            if (map.containsKey(element[1])) {
                map[element[1]]?.add(element[0])
            }
        }

        var result = -1
        for (key in map.keys) {
            if (map[key]?.size != N - 1) continue

            for (i in map[key]!!.indices) {
                if (map.containsKey(map[key]!![i]) && map[map[key]!![i]]!!.contains(key)) {
                    return -1
                }
            }
            result = key
        }
        return result
    }
}
