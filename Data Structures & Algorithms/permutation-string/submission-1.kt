class Solution() {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s2.length < s1.length) return false
        val alphavit : MutableMap<Char,Int> = mutableMapOf()
        for(el in s1){
            if(alphavit.containsKey(el)){
                alphavit[el] = alphavit[el]!! + 1
            }else{
                alphavit[el] = 1
            }
        }

        for(i in 0..s2.length-s1.length){
            var j = i
            val copyAlphavit : MutableMap<Char,Int> = alphavit.toMutableMap()
            while(copyAlphavit.containsKey(s2[j])&&copyAlphavit[s2[j]]!=0){
                copyAlphavit[s2[j]] = copyAlphavit[s2[j]]!! - 1
                if(j==(i+s1.length-1)){return true}
                j++
            }
        }
        return false
    }
}
