import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n,m) = readln().split(" ").map {it.toInt()}
    val arr = Array<Int>(n+1,{0})
    var cnt = 0
    for(i in 1..n)
        arr[i] = i
    for(a in 1..m){
        val (i,j) = readln().split(" ").map {it.toInt()}
        for(b in i..(i+j)/2){
            val temp = arr[b]
            arr[b] = arr[j-b+i]
            arr[j-b+i] = temp
        }
    }
    for(i in 1..n)
        bw.write("${arr[i]} ")
    bw.write("\n")
    bw.flush()
}

