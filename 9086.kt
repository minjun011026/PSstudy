import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n= readln().toInt()
    for(i in 1..n){
        val input = readln()
        bw.write("${input[0]}${input[input.length-1]}\n")
    }

    bw.flush()
}

