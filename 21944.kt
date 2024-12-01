import java.io.*
import java.util.TreeSet

data class CustomPair(val first: Int, val second: Int) : Comparable<CustomPair> {
    override fun compareTo(other: CustomPair): Int {
        return when {
            this.first != other.first -> this.first - other.first
            else -> this.second - other.second
        }
    }
}

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numLevelAlgorithm = HashMap<Int, Pair<Int,Int>>()
    val algorithmLevelNum = HashMap<Int, TreeSet<CustomPair>>()
    val levelNum = TreeSet<Pair<Int,Int>>(compareBy({it.first},{it.second}))
    repeat(n){
        val (num, level, algorithm) = br.readLine().split(" ").map {it.toInt()}
        numLevelAlgorithm[num] = Pair(level, algorithm)
        levelNum.add(Pair(level,num))
        algorithmLevelNum.computeIfAbsent(algorithm) { TreeSet<CustomPair>() }
            .add(CustomPair(level, num))
    }
    val m = br.readLine().toInt()
    repeat(m){
        val cmd = br.readLine().split(" ")
        when(cmd[0]) {
            "add" -> {
                val num = cmd[1].toInt()
                val level  = cmd[2].toInt()
                val algorithm = cmd[3].toInt()
                numLevelAlgorithm[num] = Pair(level, algorithm)
                levelNum.add(Pair(level, num))
                algorithmLevelNum.computeIfAbsent(algorithm) { TreeSet<CustomPair>() }
                    .add(CustomPair(level, num))
            }
            "recommend2" -> {
                if(cmd[1].toInt() == 1)
                    bw.write("${levelNum.last().second}\n")
                else
                    bw.write("${levelNum.first().second}\n")
            }
            "solved" -> {
                val num = cmd[1].toInt()
                val level =numLevelAlgorithm[num]!!.first
                val algorithm = numLevelAlgorithm[num]!!.second
                levelNum.remove(Pair(level,num))
                algorithmLevelNum[algorithm]!!.remove(CustomPair(level,num))
                numLevelAlgorithm.remove(num)
            }
            "recommend" -> {
                if(cmd[2].toInt() == 1)
                    bw.write("${algorithmLevelNum[cmd[1].toInt()]!!.last().second}\n")
                else
                    bw.write("${algorithmLevelNum[cmd[1].toInt()]!!.first().second}\n")
            }
            "recommend3" -> {
                if(cmd[1].toInt() == 1)
                    bw.write("${levelNum.higher(Pair(cmd[2].toInt(),0))?.second ?: -1}\n")
                else
                    bw.write("${levelNum.lower(Pair(cmd[2].toInt()-1,100001))?.second ?: -1}\n")
            }
        }
    }
    bw.flush()
    bw.close()
}
