class Solution {
    fun countSubstrings(s: String): Int {
    var r = 0
    for (i in s.indices) {
        var a = i
        var b = i + 1
        r++
        while (a >= 0 && b < s.length && (s[a] == s[b])) {
            r++
            a--
            b++
        }
        a = i - 1
        b = i + 1
        while (a >= 0 && b < s.length && (s[a] == s[b])) {
            r++
            a--
            b++
        }
    }
    return r
}
}
