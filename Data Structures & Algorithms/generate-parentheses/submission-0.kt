class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        fun buildCombinations(stringNow: String, countOpen : Int, countClose: Int) {
            if (countOpen == n && countClose == n) {
                result.add(stringNow)
                return
            }
            if (countOpen < n){
                buildCombinations(stringNow+"(", countOpen + 1, countClose)
            }
            if(countClose < countOpen) {
                buildCombinations(stringNow + ")", countOpen, countClose + 1)
            }
        }
        buildCombinations("",0,0)
        return result
    }
}