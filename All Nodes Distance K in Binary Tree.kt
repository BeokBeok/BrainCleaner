/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        val graph = mutableMapOf<Int, List<Int?>>()
        buildGraph(graph, root)

        val cases = mutableListOf<Int>()
        val visited = mutableListOf<Int>()
        val result = mutableListOf<Int>()
        var distance = 0

        // target 을 graph 에서 찾음
        if (target?.`val` == null) return listOf()
        visited.add(target.`val`)

        // K가 0인 경우
        if (K == 0) return visited

        // 인접한 node 값 추가
        setupAdjacentNode(graph, target.`val`, cases, visited)
        distance++

        // 케이스가 비어있지 않을 때까지 반복
        while (cases.isNotEmpty()) {
            for (i in cases.size - 1 downTo 0) {
                if (distance == K) { // depth 가 동일한 경우
                    result.add(cases[i])
                    cases.remove(cases[i])
                    continue
                } else { // depth 가 동일하지 않을 경우
                    setupAdjacentNode(graph, cases[i], cases, visited)

                    visited.add(cases[i])
                    cases.remove(cases[i])
                }
            }
            distance++
        }

        return result
    }

    private fun setupAdjacentNode(
        graph: MutableMap<Int, List<Int?>>,
        targetValue: Int,
        cases: MutableList<Int>,
        visited: MutableList<Int>
    ) {
        graph[targetValue]?.let {
            for (j in it.indices) {
                if (it[j] == null || visited.contains(it[j])) continue
                cases.add(it[j]!!)
            }
        }
        val topElement = graph.filterValues { value -> value.contains(targetValue) }.keys
        if (topElement.isNotEmpty() && !visited.contains(topElement.toIntArray()[0])) {
            cases.add(topElement.toIntArray()[0])
        }
    }

    private fun buildGraph(graph: MutableMap<Int, List<Int?>>, parent: TreeNode?) {
        if (parent == null) return

        graph[parent.`val`] = listOf(parent.left?.`val`, parent.right?.`val`)
        if (parent.left != null) buildGraph(graph, parent.left)
        if (parent.right != null) buildGraph(graph, parent.right)
    }
}
