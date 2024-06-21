import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    for(i in 1..n){
        for(j in 1..i)
            print("*")
        println()
    }
    bw.flush()
}

