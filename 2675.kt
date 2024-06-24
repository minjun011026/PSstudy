import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    repeat(n){
        val (r, s) = readln().split(" ")
        for(i in 0..s.length-1){
            for(j in 1..r.toInt())
                bw.write("${s[i]}")
        }
        bw.write("\n")
    }
    bw.flush()
}

