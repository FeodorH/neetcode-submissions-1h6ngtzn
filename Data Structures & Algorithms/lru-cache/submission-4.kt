class LRUCache(val capacity: Int) {

    val hash : MutableMap<Int,Int> = mutableMapOf()
    val history : MutableList<Int> = mutableListOf()

    fun get(key: Int): Int {
        if(hash.containsKey(key)) addToHistory(key)
        return hash.get(key)?:-1
    }

    fun put(key: Int, value: Int) {
        if (hash.containsKey(key)) {
            addToHistory(key)
            hash[key] = value
            return
        }
        if (hash.size >= capacity) {
            val oldestKey = history.removeAt(0)
            hash.remove(oldestKey)
        }
        addToHistory(key)
        hash[key] = value
    }

    private fun addToHistory(key: Int) {
        if(history.contains(key))history.remove(key)

        if(history.size < capacity) {
            history.add(key)
        }else{
            history.removeAt(0)
            history.add(key)
        }
    }
}