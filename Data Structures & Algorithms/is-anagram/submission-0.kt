class Solution {

    fun isAnagram(s: String, t: String): Boolean {
        val mS = mutableMapOf<Char, Int>()
        val mT = mutableMapOf<Char, Int>()
        if(s.length!=t.length){return false}
        for(i in 0 until s.length) {
            if(mS.containsKey(s[i])){
                mS[s[i]] = mS[s[i]] as Int + 1
            }else{
                mS[s[i]] = 1
            }
            if(mT.containsKey(t[i])){
                mT[t[i]] = mT[t[i]] as Int + 1
            }else{
                mT[t[i]] = 1
            }
        }

        return mS==mT

    }
}
