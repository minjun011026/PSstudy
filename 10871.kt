import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n,x) = readln().split(" ").map {it.toInt()}
    val st = StringTokenizer(readln())
    val arr = ArrayList<Int>()
    while(st.hasMoreTokens()) {
        arr.add(st.nextToken().toInt())
    }
    for(i in 0..n-1){
        if(x>arr[i])
            bw.write("${arr[i]} ")
    }
    bw.write("\n")
    bw.flush()
}

