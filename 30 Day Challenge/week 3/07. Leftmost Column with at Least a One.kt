/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     fun get(x:Int, y:Int):Int {}
 *     fun dimensions():List<Int> {}
 * }
 */

class Solution {
    fun leftMostColumnWithOne(binaryMatrix:BinaryMatrix):Int {
        val (row, col) = (binaryMatrix.dimensions()[0]) to (binaryMatrix.dimensions()[1])
        
        if (row == 0 || col == 0) return -1
        
        var (targetRow, targetCol) = 0 to col - 1
        var result = -1
        
        while (targetRow < row && targetCol > -1) {
            if (binaryMatrix.get(targetRow, targetCol) == 1) {
                result = targetCol
                targetCol--
            } else {
                targetRow++
            }
        }
        
        return result
    }
}
