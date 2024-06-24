import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var cnt = 0
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = ArrayList<Int>()
    while(st.hasMoreTokens()) {
        arr.add(st.nextToken().toInt())
    }
    val v = readln().toInt()
    for(i in 0..n-1){
        if(v==arr[i])
            cnt++
    }
    bw.write("$cnt\n")
    bw.flush()
}

