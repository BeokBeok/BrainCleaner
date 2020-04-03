class Solution {
    fun isHappy(n: Int): Boolean {
        var number = 0
        val digitList = getDigitList(n)
        for (element in digitList) {
            number += element.times(element)
        }
        return if (number > 9 || number == 7) {
            isHappy(number)
        } else {
            number == 1
        }
    }
    
    private fun getDigitList(n: Int): List<Int> {
        var number = n
        val digitList = mutableListOf<Int>()
        while (number > 0) {
            digitList.add(number.rem(10))
            number /= 10
        }
        return digitList
    }
}
