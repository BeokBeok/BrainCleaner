class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val arr = IntArray(26)

        for (element in magazine.toCharArray()) {
            arr[element - 'a']++
        }

        for (element in ransomNote.toCharArray()) {
            if (--arr[element - 'a'] < 0) return false
        }
        return true
    }
    
}
