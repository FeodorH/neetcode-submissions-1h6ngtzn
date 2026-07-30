class Solution {
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()
        val alphabet = mutableMapOf<Char, String>(
            Pair('2',"abc"),
            Pair('3',"def"),
            Pair('4',"ghi"),
            Pair('5',"jkl"),
            Pair('6',"mno"),
            Pair('7',"pqrs"),
            Pair('8',"tuv"),
            Pair('9',"wxyz"))
        var result = mutableListOf<String>()
        for(ch in digits) {
            val chars = alphabet[ch]
            if(chars != null) {
                if (result.isEmpty()) {
                    chars?.forEach { result.add(it.toString()) }
                    continue
                }
                val t = mutableListOf<String>()
                result.forEach { r ->
                    chars?.forEach { c ->
                        t.add(r+c)
                    }
                }
                result = t
            }
        }
        return result
    }
}
