import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n:Char = readln()[0]
    bw.write("${n.code}\n")

    bw.flush()
}

