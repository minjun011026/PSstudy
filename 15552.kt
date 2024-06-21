import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val n = readln().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(n){
        val (x,y) = readln().split(" ").map {it.toInt()}
        bw.write("${x+y}\n")
    }
    bw.flush()
}

