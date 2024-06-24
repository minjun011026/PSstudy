import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n1,n2) = readln().split(" ")
    val m1 = n1.reversed().toInt()
    val m2 = n2.reversed().toInt()
    if(m1>m2)
        bw.write("$m1")
    else
        bw.write("$m2")
    bw.flush()
}

