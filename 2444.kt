import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    for(i in 1..n){
        for(j in 1..n-i)
            bw.write(" ")
        for(j in 1..2*i-1)
            bw.write("*")
        bw.write("\n")
    }
    for(i in n-1 downTo 1){
        for(j in 1..n-i)
            bw.write(" ")
        for(j in 1..2*i-1)
            bw.write("*")
        bw.write("\n")
    }

    bw.flush()
}
