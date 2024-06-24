import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    val input = readln()
    var sum = 0
    for(i in 0..n-1)
        sum += input[i].code-48
    bw.write("$sum\n")

    bw.flush()
}

