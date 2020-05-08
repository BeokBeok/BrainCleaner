/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null) return false
        
        val graph = mutableMapOf<Int, List<Int?>>()
        buildGraph(graph, root)

        if (x != root.`val` && y != root.`val`) {
            if (graph.filterValues { it.contains(x) }.keys.toIntArray()[0] == graph.filterValues { it.contains(y) }.keys.toIntArray()[0]) return false
        }
        
        val (xDepth, yDepth) = getDepth(graph, x) to getDepth(graph, y)

        return xDepth == yDepth
    }
    
    private fun getDepth(
        graph: MutableMap<Int, List<Int?>>,
        target: Int
    ): Int {
        var currentElement = target
        var depth = 0
        while (graph.containsKey(currentElement)) {
            val topElement = graph.filterValues { it.contains(currentElement) }.keys
            if (topElement.isNotEmpty()) {
                depth++
                currentElement = topElement.toIntArray()[0]
            } else {
                break
            }
        }
        return depth
    }
    
    private fun buildGraph(graph: MutableMap<Int, List<Int?>>, parent: TreeNode?) {
        if (parent == null) return

        graph[parent.`val`] = listOf(parent.left?.`val`, parent.right?.`val`)
        if (parent.left != null) buildGraph(graph, parent.left)
        if (parent.right != null) buildGraph(graph, parent.right)
    }
}
