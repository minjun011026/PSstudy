import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    var i = 0
    val st = StringTokenizer(readln())
    val arr = ArrayList<Int>()
    var max = -1000000
    var min = 1000000
    while(st.hasMoreTokens()) {
        arr.add(st.nextToken().toInt())
        if(arr[i]>= max)
            max = arr[i]
        if(arr[i]<=min)
            min = arr[i]
        i++
    }
    bw.write("$min $max\n")
    bw.flush()
}

