import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n,m) = readln().split(" ").map {it.toInt()}
    val arr = Array<Int>(n+1,{0})
    for(i in 1..n)
        arr[i] = i
    for(a in 1..m){
        val (i,j) = readln().split(" ").map {it.toInt()}
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
    for(i in 1..n)
        bw.write("${arr[i]} ")
    bw.write("\n")
    bw.flush()
}

