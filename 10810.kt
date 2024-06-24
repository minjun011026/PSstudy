import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n,m) = readln().split(" ").map {it.toInt()}
    val arr = Array<Int>(n+1,{0})
    for(a in 1..m){
        val (i,j,k) = readln().split(" ").map {it.toInt()}
        for(num in i..j)
            arr[num] = k
    }
    for(i in 1..n)
        bw.write("${arr[i]} ")
    bw.write("\n")
    bw.flush()
}

