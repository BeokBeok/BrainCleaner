class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // 기저 case
        if (strs.isEmpty()) return listOf()

        val map = mutableMapOf<String, List<String>>()
        for (element in strs) {
            // String -> CharArr => sort
            val sortedCharArr = element.toCharArray().sortedArray()
            val key = sortedCharArr.joinToString(separator = "")
            // key 가 없는 경우
            if (!map.containsKey(key)) {
                map[key] = mutableListOf()
            }
            (map[key] as MutableList).add(element)
        }
        return map.values.toList()
    }
    
    // 더 좋은 문제 풀이
    fun advancedGroupAnagrams(strs: Array<String>): List<List<String>> =
        strs.groupBy { it.toList().sorted() }
            .map { it.value }
}
