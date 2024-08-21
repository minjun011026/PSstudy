import java.io.*
import kotlin.math.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val score = ArrayList<Int>()
    var sum = 0
    repeat(n){
        score.add(br.readLine().trim().toInt())
    }
    score.sort()

    val aver = roundFunc(score.size*0.15)

    for(i in aver .. score.lastIndex-aver){
        sum+=score[i]
    }
    bw.write("${roundFunc(sum/(score.size-aver*2.0))}")
    bw.flush()
    bw.close()
}

fun roundFunc(s : Double) : Int{
    if(s - floor(s) >=0.5) return ceil(s).toInt()
    return floor(s).toInt()
}
