import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n= readln()
    val i = readln().toInt()
    bw.write("${n[i-1]}\n")
    bw.flush()
}

