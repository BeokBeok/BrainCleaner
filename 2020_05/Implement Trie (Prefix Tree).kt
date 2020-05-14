class TrieNode {
    val child = mutableMapOf<Char, TrieNode>()
    var isEnd = false
}

class Trie() {

    /** Initialize your data structure here. */
    private val root = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node = root
        val wordToArr = word.toCharArray()
        for (element in wordToArr) {
            node = node.child.computeIfAbsent(element) {
                TrieNode()
            }
        }
        node.isEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var node = root
        val wordToArr = word.toCharArray()
        for (element in wordToArr) {
            node.child[element]?.let {
                node = it
            } ?: return false
        }
        return node.isEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var node = root
        val wordToArr = prefix.toCharArray()
        for (element in wordToArr) {
            node.child[element]?.let {
                node = it
            } ?: return false
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
