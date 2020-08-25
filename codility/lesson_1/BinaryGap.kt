fun solution(N: Int): Int {
    val binaryChars = Integer.toBinaryString(N).toCharArray()
    val oneIndexes = mutableListOf<Int>()
    binaryChars.forEachIndexed { index, c -> if (c == '1') oneIndexes.add(index) }
    
    var result = 0
    if (oneIndexes.size == 1) return result
    
    oneIndexes.forEachIndexed { index, i ->
        if (index + 1 > oneIndexes.lastIndex) return@forEachIndexed
        val diff = abs(i - oneIndexes[index + 1]) - 1
        result = diff.coerceAtLeast(result)
    }
    return result
}
