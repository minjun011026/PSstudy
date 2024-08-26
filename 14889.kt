import java.io.*
import kotlin.math.abs
import kotlin.math.min

var answer = 101

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val status = ArrayList<Array<Int>>()
    val start = ArrayList<Int>()

    repeat(n) {
        status.add(br.readLine().split(" ").map {it.toInt()}.toTypedArray())
    }

    dfs(status,0, 0, start)
    bw.write("$answer")
    bw.flush()
    bw.close()
}

fun dfs(status: ArrayList<Array<Int>>, idx : Int,cnt : Int, start : ArrayList<Int>) {
    if(cnt == status.size/2){
        val link = IntArray(status.size) {it}.filter { it !in start }
        calc(status,start,link)
        return
    }

    for(i in idx..status.lastIndex){
        start.add(i)
        dfs(status,i+1,cnt+1,start)
        start.removeLast()
    }
}

fun calc(status: ArrayList<Array<Int>>,start : ArrayList<Int>, link : List<Int>) {
    var sum1 = 0
    for(i in start){
        for(j in start){
            sum1 += status[i][j]
        }
    }

    var sum2 = 0
    for(i in link){
        for(j in link){
            sum2 += status[i][j]
        }
    }

    answer = min(answer, abs(sum1-sum2))
}
