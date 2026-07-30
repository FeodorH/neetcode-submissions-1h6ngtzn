class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0
        var num = n
        for (i in 0..31) {
            result = (result shl 1) or (num and 1)  // сдвигаем результат влево и добавляем младший бит num
            num = num ushr 1                        // беззнаковый сдвиг вправо (ushr)
        }
        return result
    }
}
