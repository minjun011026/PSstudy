import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val n = readln().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for(i in 1..n){
        val (x,y) = readln().split(" ").map {it.toInt()}
        bw.write("Case #$i: ${x+y}\n")
    }
    bw.flush()
}

