class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val sortedPeopleHeightList = people.sortedBy { it[0] }.toMutableList()
        val result = mutableListOf<IntArray>()

        var (startIndex, remainSize) = 0 to sortedPeopleHeightList.size
        while (startIndex < remainSize) {
            for (element in sortedPeopleHeightList) {
                if (result.count { it[0] >= element[0] } == element[1]) {
                    result.add(element)
                    sortedPeopleHeightList.remove(element)
                    startIndex = 0
                    break
                }
            }
            startIndex ++
        }
        return result.toTypedArray()
    }
}
