class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        var result = position.size

        for(i in position.size - 1 downTo 0) {
            var r = i
            for(j in 0 until i) {
                if(position[j]>position[r]) {
                    r=j
                }
            }
            if(i!=r){
                val p = position[i]
                val s = speed[i]
                position[i] = position[r]
                speed[i] = speed[r]
                position[r] = p
                speed[r] = s
            }
        }

        for(i in position.size - 1 downTo 0) {  // идём от ближних к target к дальним
            val timeToTarget = (target - position[i]).toDouble() / speed[i]

            if (i < position.size - 1) {
                val nextTimeToTarget = (target - position[i+1]).toDouble() / speed[i+1]
                if (timeToTarget <= nextTimeToTarget) {
                    result--  // текущая машина догонит впереди идущий флот
                    speed[i]=speed[i+1]
                    position[i]=position[i+1]
                }
            }
        }

        return result
    }
}
