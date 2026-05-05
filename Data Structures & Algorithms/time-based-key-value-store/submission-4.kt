import java.util.SortedMap

class TimeMap() {

    val hash: MutableMap<String, SortedMap<Int, String>> = mutableMapOf()

    fun set(key: String, value: String, timestamp: Int) {
        if(!hash.containsKey(key)) {
            hash[key] = sortedMapOf((timestamp to value))
        }else{
            hash[key]?.put(timestamp, value)
        }
    }

    fun get(key: String, timestamp: Int): String? {
        if(hash.containsKey(key)) {
            if(hash[key]!!.containsKey(timestamp)) return hash[key]?.get(timestamp).toString()
            else {
                val keys = hash[key]?.keys?.toList()
                var l : Int = 0
                var r : Int = keys?.lastIndex?:0
                var m : Int
                var result: String? = null
                do {
                    m = l + (r-l)/2
                    val midTimestamp = keys?.get(m)?:0
                    if(midTimestamp > timestamp){
                        r=m-1
                    }else{
                        result = hash[key]?.get(midTimestamp).toString()
                        l=m+1
                    }
                }
                while (l <= r)
                return result?:""
            }
        }else{
            return ""
        }
    }
}
