import java.io.*
import java.util.TreeSet

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numLevel = HashMap<Int, Int>()
    val levelNum = TreeSet<Pair<Int,Int>>(compareBy({it.first},{it.second}))

    repeat(n){
        val (num, level) = br.readLine().split(" ").map {it.toInt()}
        numLevel[num] = level
        levelNum.add(Pair(level,num))
    }


    val m = br.readLine().toInt()
    repeat(m){
        val cmd = br.readLine().split(" ")
        when(cmd[0]) {
            "add" -> {
                val num = cmd[1].toInt()
                val level  = cmd[2].toInt()
                numLevel[num] = level
                levelNum.add(Pair(level, num))
            }
            "recommend" -> {
                if(cmd[1].toInt() == 1) {
                    bw.write("${levelNum.last().second}\n")
                }
                else
                    bw.write("${levelNum.first().second}\n")
            }
            "solved" -> {
                val num = cmd[1].toInt()
                levelNum.remove(Pair(numLevel[num],num))
                numLevel.remove(num)
            }
        }
    }
    bw.flush()
    bw.close()
}
