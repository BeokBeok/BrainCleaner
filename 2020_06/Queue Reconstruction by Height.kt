class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(Comparator<IntArray> { o1, o2 ->
            if (o1[0] == o2[0]) {
                o1[1] - o2[1]
            } else {
                o2[0] - o1[0]
            }
        })

        return mutableListOf<IntArray>().apply {
            for (element in people) {
                add(element[1], element)
            }
        }.toTypedArray()
    }
}
