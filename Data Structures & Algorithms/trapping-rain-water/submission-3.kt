class Solution {
    fun trap(height: IntArray): Int {
        if(height.size<=2) return 0
        var a = 0
        var b = 1
        var s = 0
        var tS = 0
        while(b < height.size){
            if(height[b]<height[a]){
                tS+=height[a]-height[b];
            }else{
                s+=tS
                tS=0
                a=b
            }
            b++
        }

        val stop = a

        a = height.size - 1
        b = height.size - 2
        tS = 0

        while(b >= stop){
            if(height[b] < height[a]){
                tS += height[a] - height[b]
            } else {
                s += tS
                tS = 0
                a = b
            }
            b--
        }

        return s;
    }
}