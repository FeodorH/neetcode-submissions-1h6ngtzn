class PrefixTree {
    private val root : Node = Node(' ',false, HashMap())

    fun insert(word: String) {
        if(!word.isEmpty()) {
            insert(word,root)
        }
    }

    private fun insert(word: String, node: Node?){
        if(word.isEmpty()) return
        val ch = word[0]
        node?.let{
            if(!(node.neighbours.containsKey(ch))){
                val isEnd = if(word.length == 1) true else false
                val t = Node(ch,isEnd,HashMap())
                node.neighbours[ch] = t
            }
            else{
                if(word.length == 1) {
                    node.neighbours[ch]?.isEndOfWord = true
                }
            }
            insert(word.slice(1..<word.length),node.neighbours[ch])
        }
    }

    fun search(word: String): Boolean {
        if(!word.isEmpty()) {
            return search(word, root)
        }
        return false
    }

    private fun search(word: String, node: Node?): Boolean {
        if(node == null&&word.isNotEmpty()) return false
        val ch = word[0]
        node?.let {
            if (node.`val` == ' ')return search(word,node.neighbours[ch])
            if(word.length == 1){
                if(node.`val`==ch && node.isEndOfWord) return true
                else return false
            }
            if(node.`val`==ch) return search(word.slice(1..<word.length),node.neighbours[word[1]])
            else return false
        }
        return false
    }


    fun startsWith(prefix: String): Boolean {
        if(prefix.isEmpty()) return true
        return startsWith(prefix, root)
    }

    private fun startsWith(prefix: String, node: Node?): Boolean {
        if(node == null&&prefix.isNotEmpty()) return false
        val ch = prefix[0]
        node?.let {
            if (node.`val` == ' ')return startsWith(prefix,node.neighbours[ch])
            if(prefix.length == 1){
                if(node.`val`==ch) return true
                else return false
            }
            if(node.`val`==ch) return startsWith(prefix.slice(1..<prefix.length),node.neighbours[prefix[1]])
            else return false
        }
        return false
    }

    private data class Node(val `val`: Char, var isEndOfWord: Boolean = false, val neighbours: HashMap<Char,Node>)
}