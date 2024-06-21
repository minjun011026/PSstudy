import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    for(i in 1..n){
        for(j in 1..n-i)
            bw.write(" ")
        for(j in 1..i)
            bw.write("*")
        bw.write("\n")
    }
    bw.flush()
}

